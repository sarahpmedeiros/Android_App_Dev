package cs.hangman;

import android.app.Activity;
import android.app.Dialog;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.BooleanResult;
import com.google.android.gms.common.api.GoogleApiClient;

import static cs.hangman.R.id.left_arm;
import static cs.hangman.R.id.txtHint;
//import android.view.Display;

public class MainActivity extends AppCompatActivity {
    String word, hint;
    char[] wordChars;
    final String[] words = {"Cheese", "Bell", "Funny"};
    final String[] hints = {"Pizza", "Ring", "Laughter"};
    boolean[] buttons = {true, true, true, true, true, true, true, true,
            true, true, true, true, true, true, true, true, true, true, true, true, true,
            true, true, true, true, true};

    final Integer maxWordIndex = words.length;
    final Integer maxWrongLetters = 6;
    Integer currentWordIndex = 0;
    Integer countWrongLetters = 0;
    Integer correctLetters = 0;
    String currentWord = "";
    TextView txtWord, txtHint;
    TextView txtWordLand;
    ImageView left_arm, right_arm, left_leg, right_leg, head, body;
    Button btnA, btnB, btnC, btnD, btnE, btnF, btnG, btnH, btnI, btnJ, btnK, btnL, btnN;
    Button btnM, btnO, btnP, btnQ, btnR, btnS, btnT, btnU, btnV, btnW, btnX, btnY, btnZ;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.relHangman);
        relativeLayout.addView(new Hangman(this));

        if (savedInstanceState != null) {
            currentWordIndex = (Integer) savedInstanceState.getSerializable("currentWordIndex");
            countWrongLetters = (Integer) savedInstanceState.getSerializable("countWrongLetters");
            correctLetters = (Integer) savedInstanceState.getSerializable("correctLetters");
            currentWord = (String) savedInstanceState.getSerializable("currentWord");
            buttons = (boolean[]) savedInstanceState.getSerializable("buttons");
        }

        txtWordLand = (TextView) findViewById(R.id.txtWordLand);
        txtWord = (TextView) findViewById(R.id.txtWord);
        txtHint = (TextView) findViewById(R.id.txtHint);

        left_arm = (ImageView) findViewById(R.id.left_arm);
        right_arm = (ImageView) findViewById(R.id.right_arm );
        head = (ImageView) findViewById(R.id.head);
        body = (ImageView) findViewById(R.id.body);
        left_leg = (ImageView) findViewById(R.id.left_leg);
        right_leg = (ImageView) findViewById(R.id.right_leg );

        btnA = (Button) findViewById(R.id.btnA);
        btnB = (Button) findViewById(R.id.btnB);
        btnC = (Button) findViewById(R.id.btnC);
        btnD = (Button) findViewById(R.id.btnD);
        btnE = (Button) findViewById(R.id.btnE);
        btnF = (Button) findViewById(R.id.btnF);
        btnG = (Button) findViewById(R.id.btnG);
        btnH = (Button) findViewById(R.id.btnH);
        btnI = (Button) findViewById(R.id.btnI);
        btnJ = (Button) findViewById(R.id.btnJ);
        btnK = (Button) findViewById(R.id.btnK);
        btnL = (Button) findViewById(R.id.btnL);
        btnM = (Button) findViewById(R.id.btnM);
        btnN = (Button) findViewById(R.id.btnN);
        btnO = (Button) findViewById(R.id.btnO);
        btnP = (Button) findViewById(R.id.btnP);
        btnQ = (Button) findViewById(R.id.btnQ);
        btnR = (Button) findViewById(R.id.btnR);
        btnS = (Button) findViewById(R.id.btnS);
        btnT = (Button) findViewById(R.id.btnT);
        btnU = (Button) findViewById(R.id.btnU);
        btnV = (Button) findViewById(R.id.btnV);
        btnW = (Button) findViewById(R.id.btnW);
        btnX = (Button) findViewById(R.id.btnX);
        btnY = (Button) findViewById(R.id.btnY);
        btnZ = (Button) findViewById(R.id.btnZ);

        init(currentWordIndex, countWrongLetters, correctLetters, currentWord);


        //get button
        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkForLetter(btnA.getText().toString());
                btnA.setEnabled(false);
                buttons[0] = false;
                System.out.println("SAM" + buttons[0]);
            }
        });

        btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkForLetter(btnB.getText().toString());
                btnB.setEnabled(false);
                buttons[1] = false;

            }
        });

        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkForLetter(btnC.getText().toString());
                btnC.setEnabled(false);
                buttons[2] = false;

            }
        });

        btnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkForLetter(btnD.getText().toString());
                btnD.setEnabled(false);
                buttons[3] = false;

            }
        });

        btnE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkForLetter(btnE.getText().toString());
                btnE.setEnabled(false);
                buttons[4] = false;

            }
        });

        btnF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkForLetter(btnF.getText().toString());
                btnF.setEnabled(false);
                buttons[5] = false;

            }
        });

        btnG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkForLetter(btnG.getText().toString());
                btnG.setEnabled(false);
                buttons[6] = false;

            }
        });

        btnH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkForLetter(btnH.getText().toString());
                btnH.setEnabled(false);
                buttons[7] = false;

            }
        });

        btnI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkForLetter(btnI.getText().toString());
                btnI.setEnabled(false);
                buttons[8] = false;

            }
        });

        btnJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkForLetter(btnJ.getText().toString());
                btnJ.setEnabled(false);
                buttons[9] = false;

            }
        });

        btnK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkForLetter(btnK.getText().toString());
                btnK.setEnabled(false);
                buttons[10] = false;

            }
        });

        btnL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkForLetter(btnL.getText().toString());
                btnL.setEnabled(false);
                buttons[11] = false;

            }
        });

        btnM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkForLetter(btnM.getText().toString());
                btnM.setEnabled(false);
                buttons[12] = false;

            }
        });

        btnN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkForLetter(btnN.getText().toString());
                btnN.setEnabled(false);
                buttons[13] = false;

            }
        });
        btnO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkForLetter(btnO.getText().toString());
                btnO.setEnabled(false);
                buttons[14] = false;

            }
        });

        btnP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkForLetter(btnP.getText().toString());
                btnP.setEnabled(false);
                buttons[15] = false;

            }
        });

        btnQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkForLetter(btnQ.getText().toString());
                btnQ.setEnabled(false);
                buttons[16] = false;

            }
        });

        btnR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkForLetter(btnR.getText().toString());
                btnR.setEnabled(false);
                buttons[17] = false;

            }
        });

        btnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkForLetter(btnS.getText().toString());
                btnS.setEnabled(false);
                buttons[18] = false;

            }
        });

        btnT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkForLetter(btnT.getText().toString());
                btnT.setEnabled(false);
                buttons[19] = false;

            }
        });

        btnU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkForLetter(btnU.getText().toString());
                btnU.setEnabled(false);
                buttons[20] = false;

            }
        });

        btnV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkForLetter(btnV.getText().toString());
                btnV.setEnabled(false);
                buttons[21] = false;

            }
        });

        btnW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkForLetter(btnW.getText().toString());
                btnW.setEnabled(false);
                buttons[22] = false;

            }
        });

        btnX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkForLetter(btnX.getText().toString());
                btnX.setEnabled(false);
                buttons[23] = false;

            }
        });

        btnY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkForLetter(btnY.getText().toString());
                btnY.setEnabled(false);
                buttons[24] = false;

            }
        });

        btnZ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkForLetter(btnZ.getText().toString());
                btnZ.setEnabled(false);
                buttons[25] = false;

            }
        });

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


    protected void checkForLetter(String letter) {
        boolean inWord = false;
        char[] currentChars = currentWord.toCharArray();
        currentWord = "";
        int orient = getResources().getConfiguration().orientation;

        for (int i = 0; i < word.length(); i++) {
            if (letter.equals(Character.toString(wordChars[i]).toUpperCase())) {
                inWord = true;
                currentWord = currentWord + letter + " ";
                correctLetters += 1;
            } else {
                currentWord = currentWord + Character.toString(currentChars[(i * 2)]) + " ";
            }
        }

        if (orient == 1) {
            txtWord.setText(currentWord);
        } else {
            txtWordLand.setText(currentWord);
        }

        if (inWord) {
            Toast.makeText(getBaseContext(), "RIGHT", Toast.LENGTH_SHORT).show();
            if (correctLetters == word.length()) {
                endGame("WINNER!");
            }
        } else {
            Toast.makeText(getBaseContext(), "WRONG", Toast.LENGTH_SHORT).show();

            if (countWrongLetters.equals(0)){
                head.setVisibility(View.VISIBLE);
            }
            else if (countWrongLetters.equals(1)){
                body.setVisibility(View.VISIBLE);
            }else if (countWrongLetters.equals(2)){
                left_arm.setVisibility(View.VISIBLE);
            }else if (countWrongLetters.equals(3)){
                right_arm.setVisibility(View.VISIBLE);
            }else if (countWrongLetters.equals(4)){
                left_leg.setVisibility(View.VISIBLE);
            }else if (countWrongLetters.equals(5)) {
                right_leg.setVisibility(View.VISIBLE);
            }


            countWrongLetters += 1;
            if (countWrongLetters.equals(maxWrongLetters)) {
                endGame("LOSER!");
            }
        }

    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("currentWord", currentWord);
        savedInstanceState.putInt("currentWordIndex", currentWordIndex);
        savedInstanceState.putInt("countWrongLetters", countWrongLetters);
        savedInstanceState.putInt("correctLetters", correctLetters);
        savedInstanceState.putBooleanArray("buttons", buttons);
    }

    protected void endGame(String outcome) {
        Button btn_no, btn_yes;
        TextView txtOutcome;
        final Dialog dialog = new Dialog(this);

        dialog.setCanceledOnTouchOutside(false);
        dialog.setContentView(R.layout.custom_dialog);
        txtOutcome = (TextView) dialog.findViewById(R.id.txtOutcome);
        btn_yes = (Button) dialog.findViewById(R.id.btn_yes);
        btn_no = (Button) dialog.findViewById(R.id.btn_no);
        txtOutcome.setText(outcome + " Play again?");

        btn_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                finish();
            }
        });

        btn_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                newGame();
            }
        });
        dialog.show();
    }

    protected void newGame() {
        enableButtons();

        head.setVisibility(View.INVISIBLE);
        body.setVisibility(View.INVISIBLE);
        left_leg.setVisibility(View.INVISIBLE);
        right_leg.setVisibility(View.INVISIBLE);
        left_arm.setVisibility(View.INVISIBLE);
        right_arm.setVisibility(View.INVISIBLE);


        if (currentWordIndex + 1 < maxWordIndex) {
            currentWordIndex += 1;
        } else {
            currentWordIndex = 0;
        }

        for (int i = 0; i < buttons.length; i++){
            buttons[i] = true;
        }

        init(currentWordIndex, 0, 0, "");
    }

    protected void enableButtons() {
        btnA.setEnabled(true);
        btnB.setEnabled(true);
        btnC.setEnabled(true);
        btnD.setEnabled(true);
        btnE.setEnabled(true);
        btnF.setEnabled(true);
        btnG.setEnabled(true);
        btnH.setEnabled(true);
        btnI.setEnabled(true);
        btnJ.setEnabled(true);
        btnK.setEnabled(true);
        btnL.setEnabled(true);
        btnM.setEnabled(true);
        btnN.setEnabled(true);
        btnO.setEnabled(true);
        btnP.setEnabled(true);
        btnQ.setEnabled(true);
        btnR.setEnabled(true);
        btnS.setEnabled(true);
        btnT.setEnabled(true);
        btnU.setEnabled(true);
        btnV.setEnabled(true);
        btnW.setEnabled(true);
        btnX.setEnabled(true);
        btnY.setEnabled(true);
        btnZ.setEnabled(true);
    }

    protected void enableDisableButtons(Boolean a, Boolean b, Boolean c, Boolean d,
                                        Boolean e, Boolean f, Boolean g, Boolean h,
                                        Boolean i, Boolean j, Boolean k, Boolean l,
                                        Boolean m, Boolean n, Boolean o, Boolean p,
                                        Boolean q, Boolean r, Boolean s, Boolean t,
                                        Boolean u, Boolean v, Boolean w, Boolean x,
                                        Boolean y, Boolean z) {
        btnA.setEnabled(a);
        btnB.setEnabled(b);
        btnC.setEnabled(c);
        btnD.setEnabled(d);
        btnE.setEnabled(e);
        btnF.setEnabled(f);
        btnG.setEnabled(g);
        btnH.setEnabled(h);
        btnI.setEnabled(i);
        btnJ.setEnabled(j);
        btnK.setEnabled(k);
        btnL.setEnabled(l);
        btnM.setEnabled(m);
        btnN.setEnabled(n);
        btnO.setEnabled(o);
        btnP.setEnabled(p);
        btnQ.setEnabled(q);
        btnR.setEnabled(r);
        btnS.setEnabled(s);
        btnT.setEnabled(t);
        btnU.setEnabled(u);
        btnV.setEnabled(v);
        btnW.setEnabled(w);
        btnX.setEnabled(x);
        btnY.setEnabled(y);
        btnZ.setEnabled(z);
    }


    public void init(Integer index, Integer wrongLetters, Integer correct, String curWord) {
        countWrongLetters = wrongLetters;
        correctLetters = correct;

        word = words[index];
        hint = hints[index];

        wordChars = word.toCharArray();

        int orient;
        orient = getResources().getConfiguration().orientation;

        if (curWord.equals("")) {
            currentWord = "";
            for (int i = 0; i < word.length(); i++) {
                currentWord += "_ ";
            }
        } else {
            currentWord = curWord;
        }

        if (orient == 1) {
            txtWord.setText(currentWord);
        } else {
            txtHint.setText(hint);
            txtWordLand.setText(currentWord);
        }

        enableDisableButtons(buttons[0], buttons[1], buttons[2], buttons[3],
                buttons[4], buttons[5], buttons[6], buttons[7],
                buttons[8], buttons[9], buttons[10], buttons[11],
                buttons[12], buttons[13], buttons[14], buttons[15],
                buttons[16], buttons[17], buttons[18], buttons[19],
                buttons[20], buttons[21], buttons[22], buttons[23],
                buttons[24], buttons[25]);


        if (countWrongLetters > 0){
            head.setVisibility(View.VISIBLE);
        }
        if (countWrongLetters > 1){
            body.setVisibility(View.VISIBLE);
        }
        if (countWrongLetters > 2){
            left_arm.setVisibility(View.VISIBLE);
        }
        if (countWrongLetters > 3){
            right_arm.setVisibility(View.VISIBLE);
        }
        if (countWrongLetters> 4){
            left_leg.setVisibility(View.VISIBLE);
        }
        if (countWrongLetters>5) {
            right_leg.setVisibility(View.VISIBLE);
        }

    }


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
