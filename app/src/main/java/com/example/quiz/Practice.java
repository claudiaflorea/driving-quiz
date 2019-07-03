package com.example.quiz;

import android.support.v4.app.Fragment;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;


public class Practice extends Fragment implements View.OnClickListener {

    TextView questionText;
    ImageView pedestrians_sign, dead_end_sign, merging_traffic, railroad_cross;
    RadioGroup radioGroup;
    RadioButton option1, option2, option3, option4;
    Button btnSubmit, btnNext;
    TextView textViewScore;
    AssetManager assetManager;
    int rowNumber = 1;
    String answer = null;
    HSSFCell myCell;
    Iterator<Cell> cellIter;
    InputStream inputStream;
    POIFSFileSystem myFileSystem;
    HSSFWorkbook myWorkBook;
    HSSFSheet mySheet;
    Iterator<Row> rowIter;
    HSSFRow myRow;
    String cellString;
    int Score = 0;
    boolean submitted;
    static final String SCOREKEY = "key1";
    View v;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

         v = inflater.inflate(
                R.layout.practice, container, false);

        //questionNumber = (TextView)v.findViewById(R.id.qNo);
        questionText = (TextView) v.findViewById(R.id.tvQuestion);
        pedestrians_sign= (ImageView) v.findViewById(R.id.pedestrians_sign);
        dead_end_sign= (ImageView) v.findViewById(R.id.dead_end_sign);
        railroad_cross= (ImageView) v.findViewById(R.id.railroad);
        merging_traffic= (ImageView) v.findViewById(R.id.merging_right);

        option1 = (RadioButton) v.findViewById(R.id.rbOption1);
        option2 = (RadioButton) v.findViewById(R.id.rbOption2);
        option3 = (RadioButton) v.findViewById(R.id.rbOption3);
        option4 = (RadioButton) v.findViewById(R.id.rbOption4);

        radioGroup = (RadioGroup) v.findViewById(R.id.rg);

        btnSubmit = (Button) v.findViewById(R.id.btnSubmit);
        btnNext = (Button) v.findViewById(R.id.btnNext);

        btnSubmit.setOnClickListener(this);
        btnNext.setOnClickListener(this);

        Score = 0;

        textViewScore = (TextView)v.findViewById(R.id.tvScore);

        try {
            assetManager = getActivity().getAssets();
            inputStream = assetManager.open("excel1.xls");

            myFileSystem = new POIFSFileSystem(inputStream);
            myWorkBook = new HSSFWorkbook(myFileSystem);
            mySheet = myWorkBook.getSheetAt(0);
            rowIter = mySheet.rowIterator();

            while (rowIter.hasNext()) {
                myRow = (HSSFRow) rowIter.next();
                    cellIter = myRow.cellIterator();
                    break;
            }

        }catch (IOException e) {
            e.printStackTrace();
        }

        fetchDataFromExcel();
        Log.d("TAG", "onCreateView: ");
        btnSubmit.setClickable(true);
        return v;
    }

    private void nextCell() {
        if(cellIter.hasNext()) {
            myCell = (HSSFCell) cellIter.next();
        }
        cellString = myCell.toString();
    }

    private void nextRow() {
        if(rowIter.hasNext()){
            myRow = (HSSFRow) rowIter.next();
        }
        cellIter = myRow.cellIterator();
    }

    private void fetchDataFromExcel() {

        submitted = false;
        btnSubmit.setClickable(true);

        option1.setVisibility(View.VISIBLE);
        option2.setVisibility(View.VISIBLE);
        option3.setVisibility(View.VISIBLE);
        option4.setVisibility(View.VISIBLE);
        pedestrians_sign.setVisibility(View.GONE);
        dead_end_sign.setVisibility(View.GONE);
        merging_traffic.setVisibility(View.GONE);
        railroad_cross.setVisibility(View.GONE);
        radioGroup.clearCheck();

        for (int i = 0; i < radioGroup.getChildCount(); i++) {
            radioGroup.getChildAt(i).setEnabled(true);
        }

        rowNumber = myRow.getRowNum()+1;
        nextCell();

        questionText.setText(cellString);
        nextCell();

        if (cellString != null) {
            option1.setText(cellString);
            nextCell();
        } else {
            option1.setVisibility(View.INVISIBLE);
            nextCell();
        }

        if (cellString != null) {
            option2.setText(cellString);
            nextCell();
        } else {
            option2.setVisibility(View.INVISIBLE);
            nextCell();
        }

        if (cellString != null) {
            option3.setText(cellString);
            nextCell();
        } else {
            option3.setVisibility(View.INVISIBLE);
            nextCell();
        }

        if (cellString != null) {
            option4.setText(cellString);
            nextCell();
        } else {
            option4.setVisibility(View.INVISIBLE);
            Log.d("TAG", "fetchDataFromExcel: option4 ");
            nextCell();
        }
        answer = cellString;
        rowNumber++;

        switch(this.rowNumber){
            case 15:
                dead_end_sign.setVisibility(View.VISIBLE);
                break;
            case 17:
                pedestrians_sign.setVisibility(View.VISIBLE);
                break;
            case 19:
                railroad_cross.setVisibility(View.VISIBLE);
                break;
            case 25:
                merging_traffic.setVisibility(View.VISIBLE);
                break;
        }

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btnSubmit:

                if(radioGroup.getCheckedRadioButtonId()== -1){
                    Toast.makeText(getActivity(), "You need to select an answer.", Toast.LENGTH_SHORT).show();
                }else {
                    submitted = true;
                    if ((((RadioButton) v.findViewById((radioGroup.getCheckedRadioButtonId()))).getText().toString()).equalsIgnoreCase(answer)) {
                        Toast.makeText(getActivity(), "Correct !!!", Toast.LENGTH_SHORT).show();
                        Score++;
                        textViewScore.setText(""+Score);

                        for (int i = 0; i < radioGroup.getChildCount(); i++) {
                            radioGroup.getChildAt(i).setEnabled(false);
                        }
                        btnSubmit.setClickable(false);

                    } else {
                        Toast.makeText(getActivity(), "Incorrect", Toast.LENGTH_SHORT).show();
                        for (int i = 0; i < radioGroup.getChildCount(); i++) {
                            radioGroup.getChildAt(i).setEnabled(false);
                        }
                        btnSubmit.setClickable(false);
                    }
                }

                if (rowNumber == 26) {
                    Toast.makeText(getActivity(), ""+Score, Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getActivity(),ClarifyDoubt.class);
                    i.putExtra(MainActivity.SCOREKEY,Score);
                    startActivity(i);
                    }

                break;
            case R.id.btnNext:
                if (submitted) {
                    if (radioGroup.getCheckedRadioButtonId() == -1) {
                        Toast.makeText(getActivity(), "You can't skip a question.", Toast.LENGTH_SHORT).show();
                    } else {
                        nextRow();
                        fetchDataFromExcel();
                    }
                }else {
                    Toast.makeText(getActivity(), "You need to submit the answer.", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

}