package com.example.pavle.jmbgprovera;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity
{

    private int dan, mesec, godina;
    private String drzava;
    private int muski_pol, zenski_pol;
    private int A, B, V, G, D, Đ, E, Ž, Z, I, J, K, L;
    private int kontrolna_cifra;

    private TextView textView_republika,textView_region,textView_datum,textView_pol,textView_redni_broj,textView1,
            textView2,textView3;
    private EditText editText1,editText2;
    private Button button_okrug,button_reset;
    private ImageView imageView_drzava;
    private View line;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        textView_republika = (TextView) findViewById(R.id.textView_republika);
        textView_datum = (TextView) findViewById(R.id.textView_datum);
        textView_region = (TextView) findViewById(R.id.textView_region);
        textView_pol = (TextView) findViewById(R.id.textView_pol);
        textView_redni_broj = (TextView) findViewById(R.id.textView_redni_broj);
        editText1 = (EditText) findViewById(R.id.editText_jmbg);
        imageView_drzava = (ImageView) findViewById(R.id.imageView_drzava);
        button_okrug = (Button) findViewById(R.id.button_okrug);
        button_reset = (Button) findViewById(R.id.button_reset);

        textView1 = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);

        line = (View) findViewById(R.id.line);

        //editText1.setText("");
        textView_republika.setVisibility(View.GONE);
        textView_region.setVisibility(View.GONE);
        textView_datum.setVisibility(View.GONE);
        textView_pol.setVisibility(View.GONE);
        textView_redni_broj.setVisibility(View.GONE);
        button_okrug.setVisibility(View.GONE);
        button_reset.setVisibility(View.GONE);
        imageView_drzava.setVisibility(View.GONE);

        textView1.setVisibility(View.GONE);
        textView2.setVisibility(View.GONE);
        textView3.setVisibility(View.GONE);

        line.setVisibility(View.GONE);

        jmbg();

        button_reset.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                editText1.setText("");
                textView_republika.setText("");
                textView_region.setText("");
                textView_datum.setText("");
                textView_pol.setText("");
                textView_redni_broj.setText("");
                button_okrug.setEnabled(false);
                editText1.requestFocus();
                imageView_drzava.setImageResource(0);
            }
        });

        button_okrug.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                region_button();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            Intent intent = new Intent(MainActivity.this,About.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed()
    {
        createDialog();
    }

    public void createDialog()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle("Confirmation Dialog");
        builder.setMessage("Are you sure you want to exit application?");
        builder.setPositiveButton("Ok",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MainActivity.super.onBackPressed();
                    }
                });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void jmbg()
    {
        editText1.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2)
            {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2)
            {

            }

            @Override
            public void afterTextChanged(Editable editable)
            {
                String jmbgUnos;

                jmbgUnos = editText1.getText().toString();

                for (int j = 0; j < jmbgUnos.length(); j++)
                {
                    if (jmbgUnos.length() == 13)
                    {
                        //kontrolni_broj(kontrolna_cifra);
                        proveriJMBG(jmbgUnos);
                        button_okrug.setEnabled(true);
                        button_reset.setEnabled(true);
                        textView_republika.setVisibility(View.VISIBLE);
                        textView_region.setVisibility(View.VISIBLE);
                        textView_datum.setVisibility(View.VISIBLE);
                        textView_pol.setVisibility(View.VISIBLE);
                        textView_redni_broj.setVisibility(View.VISIBLE);
                        button_okrug.setVisibility(View.VISIBLE);
                        button_reset.setVisibility(View.VISIBLE);
                        editText1.setVisibility(View.VISIBLE);
                        editText1.setTextColor(Color.GREEN);
                        imageView_drzava.setVisibility(View.VISIBLE);

                        textView1.setVisibility(View.VISIBLE);
                        textView2.setVisibility(View.VISIBLE);
                        textView3.setVisibility(View.VISIBLE);

                        line.setVisibility(View.VISIBLE);
                        break;
                    } else
                        editText1.setTextColor(Color.RED);
                    continue;
                }
            }
        });
    }

    public void region_button()
    {

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        if (drzava.startsWith("7"))
        {
            if (drzava.equals("71"))
            {
                builder.setTitle("Region Beograd");
                builder.setMessage("Grad Beograd: Stari Grad, Savski Venac, Voždovac, Vračar, Palilula, Zvezdara, Rakovica, Čukarica, Novi Beograd, Zemun, Mladenovac, Barajevo, Grocka, Obrenovac, Sopot, Lazarevac")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i)
                            {
                                dialogInterface.dismiss();
                            }
                        });
                AlertDialog alert11 = builder.create();
                alert11.show();
            }
            if (drzava.equals("72"))
            {
                builder.setTitle("Region Šumadija i Pomoravlje");
                builder.setMessage("Šumadijski okrug: Aranđelovac, Batočina, Knić, Kragujevac, Rača, Lapovo, Topola), (Pomoravski okrug: Despotovac, Paraćin, Rekovac, Jagodina, Svilajnac, Ćuprija")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i)
                            {
                                dialogInterface.dismiss();
                            }
                        });
                AlertDialog alert11 = builder.create();
                alert11.show();
            }
            if (drzava.equals("73"))
            {

                builder.setTitle("Region Niš");
                builder.setMessage("Nišavski okrug: Aleksinac, Svrljig, Niš, Gadžin Han, Doljevac, Merošina, Ražanj), (Pirotski okrug: Babušnica, Bela Palanka, Dimitrovgrad, Pirot), (Toplički okrug: Blace, Žitorađa, Prokuplje, Kuršumlija")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i)
                            {
                                dialogInterface.dismiss();
                            }
                        });
                AlertDialog alert11 = builder.create();
                alert11.show();
            }
            if (drzava.equals("74"))
            {
                builder.setTitle("Južna Morava region");
                builder.setMessage("Jablanički okrug: Leskovac, Vlasotince, Medveđa, Lebane, Bojnik, Crna Trava), (Pčinjski okrug: Vranje, Bujanovac, Surdulica, Bosilegrad, Preševo, Trgovište, Vladičin Han")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i)
                            {
                                dialogInterface.dismiss();
                            }
                        });
                AlertDialog alert11 = builder.create();
                alert11.show();
            }
            if (drzava.equals("75"))
            {
                builder.setTitle("Zaječar region");
                builder.setMessage("Zaječarski okrug: Zaječar, Boljevac, Knjaževac, Sokobanja), (Borski okrug: Bor, Majdanpek, Kladovo, Negotin")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i)
                            {
                                dialogInterface.dismiss();
                            }
                        });
                AlertDialog alert11 = builder.create();
                alert11.show();
            }
            if (drzava.equals("76"))
            {
                builder.setTitle("Podunavlje region");
                builder.setMessage("Podunavski okrug: Smederevska Palanka, Velika Plana, Smederevo), (Braničevski okrug: Veliko Gradište, Kučevo, Petrovac na Mlavi, Požarevac, Žagubica, Golubac, Žabari, Malo Crniće")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i)
                            {
                                dialogInterface.dismiss();
                            }
                        });
                AlertDialog alert11 = builder.create();
                alert11.show();
            }
            if (drzava.equals("77"))
            {
                builder.setTitle("Podrinje i Kolubara region");
                builder.setMessage("Mačvanski okrug: Loznica, Krupanj, Ljubovija, Šabac, Bogatić, Koceljeva, Vladimirci, Mali Zvornik), (Kolubarski okrug: Valjevo, Lajkovac, Ljig, Ub, Osečina, Mionoca")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i)
                            {
                                dialogInterface.dismiss();
                            }
                        });
                AlertDialog alert11 = builder.create();
                alert11.show();
            }
            if (drzava.equals("78"))
            {
                builder.setTitle("Kraljevo region");
                builder.setMessage("Raški okrug: Kraljevo, Vrnjačka Banja, Novi Pazar, Raška, Tutin), (Moravički okrug: Gornji Milanovac, Čačak, Ivanjica, Lučani), (Rasinski okrug: Aleksandrovac, Brus, Kruševac, Trstenik, Varvarin, Ćićevac")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i)
                            {
                                dialogInterface.dismiss();
                            }
                        });
                AlertDialog alert11 = builder.create();
                alert11.show();
            }
            if (drzava.equals("79"))
            {
                builder.setTitle("Užice region");
                builder.setMessage("Zlatiborski okrug: Arilje, Bajina Bašta, Kosjerić, Nova Varoš, Požega, Priboj, Prijepolje, Sjenica, Užice, Čajetina")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i)
                            {
                                dialogInterface.dismiss();
                            }
                        });
                AlertDialog alert11 = builder.create();
                alert11.show();
            }
        } else if (drzava.startsWith("8"))
        {
            if (drzava.equals("80"))
            {
                builder.setTitle("Novi Sad region");
                builder.setMessage("Južnobački okrug: Bač, Bačka Palanka, Bački Petrovac, Vrbas, Žabalj, Novi Sad, Srbobran, Sremski Karlovci, Temerin, Titel, Bečej, Beočin")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i)
                            {
                                dialogInterface.dismiss();
                            }
                        });
                AlertDialog alert11 = builder.create();
                alert11.show();
            }
            if (drzava.equals("81"))
            {
                builder.setTitle("Sombor region");
                builder.setMessage("Zapadnobački okrug: Apatin, Kula, Odžaci, Sombor")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i)
                            {
                                dialogInterface.dismiss();
                            }
                        });
                AlertDialog alert11 = builder.create();
                alert11.show();
            }
            if (drzava.equals("82"))
            {
                builder.setTitle("Subotica region");
                builder.setMessage("Severnobački okrug: Bačka Topola, Subotica, Mali Iđoš")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i)
                            {
                                dialogInterface.dismiss();
                            }
                        });
                AlertDialog alert11 = builder.create();
                alert11.show();
            }
            if (drzava.equals("85"))
            {
                builder.setTitle("Zrenjanin region");
                builder.setMessage("Srednjebanatski okrug: Zrenjanin, Nova Crnja, Novi Bečej, Sečanj, Žitište")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i)
                            {
                                dialogInterface.dismiss();
                            }
                        });
                AlertDialog alert11 = builder.create();
                alert11.show();
            }
            if (drzava.equals("86"))
            {
                builder.setTitle("Pančevo region");
                builder.setMessage("Južnobanatski okrug: Alibunar, Bela Crkva, Vršac, Kovačica, Kovin, Pančevo, Opovo, Plandište")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i)
                            {
                                dialogInterface.dismiss();
                            }
                        });
                AlertDialog alert11 = builder.create();
                alert11.show();
            }
            if (drzava.equals("87"))
            {
                builder.setTitle("Kikinda region");
                builder.setMessage("Severnobanatski okrug: Ada, Kikinda, Kanjiža, Novi Kneževac, Senta, Čoka")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i)
                            {
                                dialogInterface.dismiss();
                            }
                        });
                AlertDialog alert11 = builder.create();
                alert11.show();
            }
            if (drzava.equals("88"))
            {
                builder.setTitle("Ruma region");
                builder.setMessage("Sremski okrug: Inđija, Pećinci, Ruma, Sremska Mitrovica, Stara Pazova, Šid, Irig")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i)
                            {
                                dialogInterface.dismiss();
                            }
                        });
                AlertDialog alert11 = builder.create();
                alert11.show();
            }
            if (drzava.equals("89"))
            {
                builder.setTitle("Sremska Mitrovica region");
                builder.setMessage("Sremski okrug: Inđija, Pećinci, Ruma, Sremska Mitrovica, Stara Pazova, Šid, Irig")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i)
                            {
                                dialogInterface.dismiss();
                            }
                        });
                AlertDialog alert11 = builder.create();
                alert11.show();
            }
        } else if (drzava.startsWith("9"))
        {
            if (drzava.equals("91"))
            {
                builder.setTitle("Priština region");
                builder.setMessage("Kosovski okrug: Priština, Obilić, Podujevo, Štrpce, Lipljan, Glogovac, Kačanik, Kosovo Polje, Uroševac, Štimlje")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i)
                            {
                                dialogInterface.dismiss();
                            }
                        });
                AlertDialog alert11 = builder.create();
                alert11.show();
            }
            if (drzava.equals("92"))
            {
                builder.setTitle("Kosovska Mitrovica region");
                builder.setMessage("Kosovsko Mitrovački okrug: Kosovska Mitrovica, Zvečan, Leposavić, Zubin Potok, Vučitrn, Srbica")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i)
                            {
                                dialogInterface.dismiss();
                            }
                        });
                AlertDialog alert11 = builder.create();
                alert11.show();
            }
            if (drzava.equals("93"))
            {
                builder.setTitle("Peć region");
                builder.setMessage("Pećki okrug: Peć, Istok, Klina")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i)
                            {
                                dialogInterface.dismiss();
                            }
                        });
                AlertDialog alert11 = builder.create();
                alert11.show();
            }
            if (drzava.equals("94"))
            {
                builder.setTitle("Đakovica region");
                builder.setMessage("Pećki okrug: Dečani, Đakovica")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i)
                            {
                                dialogInterface.dismiss();
                            }
                        });
                AlertDialog alert11 = builder.create();
                alert11.show();
            }
            if (drzava.equals("95"))
            {
                builder.setTitle("Prizren region");
                builder.setMessage("Prizrenski okrug: Gora-Dragaš, Orahovac, Prizren, Suva Reka")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i)
                            {
                                dialogInterface.dismiss();
                            }
                        });
                AlertDialog alert11 = builder.create();
                alert11.show();
            }
            if (drzava.equals("96"))
            {
                builder.setTitle("Kosovsko Pomoravski okrug");
                builder.setMessage("Gnjilane, Kosovska Kamenica, Vitina, Novo Brdo")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i)
                            {
                                dialogInterface.dismiss();
                            }
                        });
                AlertDialog alert11 = builder.create();
                alert11.show();
            }
        } else
        {
            editText1.setTextColor(Color.RED);
            Toast.makeText(MainActivity.this, "Pogresna drzava", Toast.LENGTH_SHORT).show();
            return;
        }
    }

    private void proveriJMBG(String jmbgUnos)
    {
        try
        {
            dan = Integer.parseInt(editText1.getText().toString().substring(0, editText1.getText().length() - 11));
            mesec = Integer.parseInt(editText1.getText().toString().substring(2, editText1.getText().length() - 9));
            godina = Integer.parseInt(editText1.getText().toString().substring(4, editText1.getText().length() - 6));

            //Provera godine
            //if (Integer.toString(godina).equals("0"))
            if (godina == 0)
            {
                godina += 2000;
            } else
            {
                godina += 1000;
            }

            textView_datum.setText(dan + "." + mesec + "." + godina);

            drzava = editText1.getText().toString().substring(7, editText1.getText().length() - 4);
            proveri_mesec_dan_godinu(dan, mesec, godina);
            proveri_drzavu_grad(drzava);
            provera_pol(muski_pol, zenski_pol);
            kontrolni_broj(kontrolna_cifra);
        }
        catch (Exception ex)
        {
            Toast.makeText(MainActivity.this,ex.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }

    private boolean proveri_mesec_dan_godinu(int dan, int mesec, int godina)
    {
            /*Calendar c = Calendar.getInstance();

            SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy"));
            String formattedDate = df.format(c.getTime());*/

        if (mesec == 1 && dan > 31)
        {
            editText1.setTextColor(Color.RED);
            Toast.makeText(MainActivity.this, "Januar ne moze da ima vise od 31 dan!", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (mesec == 2 && godina % 4 == 0 && dan > 29)
        {
            editText1.setTextColor(Color.RED);
            Toast.makeText(MainActivity.this, "Februar ne moze da ima vise od 29 dana ako je godina prestupna!", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (mesec == 2 && godina % 4 != 0 && dan > 28)
        {
            editText1.setTextColor(Color.RED);
            Toast.makeText(MainActivity.this, "Februar ne moze da ima vise od 28 dana ako godina nije prestupna!", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (mesec == 3 && dan > 31)
        {
            editText1.setTextColor(Color.RED);
            Toast.makeText(MainActivity.this, "Mart ne moze da ima vise od 31 dan!", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (mesec == 4 && dan > 30)
        {
            editText1.setTextColor(Color.RED);
            Toast.makeText(MainActivity.this, "April ne moze da ima vise od 30 dana!", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (mesec == 5 && dan > 31)
        {
            editText1.setTextColor(Color.RED);
            Toast.makeText(MainActivity.this, "Maj ne moze da ima vide od 31 dan!", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (mesec == 6 && dan > 30)
        {
            editText1.setTextColor(Color.RED);
            Toast.makeText(MainActivity.this, "Jun ne moze da ima vide od 30 dana!", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (mesec == 7 && dan > 31)
        {
            editText1.setTextColor(Color.RED);
            Toast.makeText(MainActivity.this, "Jul ne moze da ima vide od 31 dan!", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (mesec == 8 && dan > 31)
        {
            editText1.setTextColor(Color.RED);
            Toast.makeText(MainActivity.this, "Avgust ne moze da ima vide od 31 dan!", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (mesec == 9 && dan > 30)
        {
            editText1.setTextColor(Color.RED);
            Toast.makeText(MainActivity.this, "Septembar ne moze da ima vide od 30 dana!", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (mesec == 10 && dan > 31)
        {
            editText1.setTextColor(Color.RED);
            Toast.makeText(MainActivity.this, "Oktobar ne moze da ima vide od 31 dan!", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (mesec == 11 && dan > 30)
        {
            editText1.setTextColor(Color.RED);
            Toast.makeText(MainActivity.this, "Novembar ne moze da ima vide od 30 dana!", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (mesec == 12 && dan > 31)
        {
            editText1.setTextColor(Color.RED);
            Toast.makeText(MainActivity.this, "Septembar ne moze da ima vide od 31 dan!", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (mesec == 13)
        {
            editText1.setTextColor(Color.RED);
            Toast.makeText(MainActivity.this, "Pogresan mesec!", Toast.LENGTH_SHORT).show();
            return false;
        }
            /*if (godina < 1900)
            {
                Toast.makeText(MainActivity.this, "Godina ne moze da bude manja od 1900-te!", Toast.LENGTH_SHORT).show();
                return false;
            }
            if (godina > Integer.parseInt(formattedDate))
            {
                Toast.makeText(MainActivity.this, "Godina ne moze da bude veca od sadanje!", Toast.LENGTH_SHORT).show();
                return false;
            }*/
        else
        {
            editText1.setTextColor(Color.GREEN);
            return true;
        }
    }

    private void proveri_drzavu_grad(String drzava)
    {
        //Bez drzavaljanstva
        if (drzava.startsWith("0"))
        {
            if (drzava.equals("01") || drzava.equals("02") || drzava.equals("03") || drzava.equals("04") || drzava.equals("05") || drzava.equals("07") || drzava.equals("08") || drzava.equals("09"))
            {
                textView_republika.setText("Stranci bez državljanstva bivše SFRJ ili njenih naslednica");
                imageView_drzava.setImageResource(R.drawable.flag_int);
            }
            if (drzava.equals("01"))
                textView_region.setText("Stranci u BiH");
            if (drzava.equals("02"))
                textView_region.setText("Stranci u Crnoj Gori");
            if (drzava.equals("03"))
                textView_region.setText("Stranci u Hrvatskoj");
            if (drzava.equals("04"))
                textView_region.setText("Stranci u Makedoniji");
            if (drzava.equals("05"))
                textView_region.setText("Stranci u Sloveniji");
            if (drzava.equals("07"))
                textView_region.setText("Stranci u Srbiji (bez pokrajina)");
            if (drzava.equals("08"))
                textView_region.setText("Stranci u Vojvodini");
            if (drzava.equals("09"))
                textView_region.setText("Stranci na Kosovu");
        }

        //BIH
        else if (drzava.startsWith("1"))
        {
            if (drzava.equals("10") || drzava.equals("11") || drzava.equals("12") || drzava.equals("13") || drzava.equals("14") || drzava.equals("15") || drzava.equals("16") || drzava.equals("17") || drzava.equals("18") || drzava.equals("19"))
            {
                textView_republika.setText("Bosna i Hercegovina");
                imageView_drzava.setImageResource(R.drawable.flag_ba);
            }
            if (drzava.equals("10"))
                textView_region.setText("Banja Luka");
            if (drzava.equals("11"))
                textView_region.setText("Bihać");
            if (drzava.equals("12"))
                textView_region.setText("Doboj");
            if (drzava.equals("13"))
                textView_region.setText("Goražde");
            if (drzava.equals("14"))
                textView_region.setText("Livno");
            if (drzava.equals("15"))
                textView_region.setText("Mostar");
            if (drzava.equals("16"))
                textView_region.setText("Prijedor");
            if (drzava.equals("17"))
                textView_region.setText("Sarajevo");
            if (drzava.equals("18"))
                textView_region.setText("Tuzla");
            if (drzava.equals("19"))
                textView_region.setText("Zenica");
        }

        //Crna Gora
        else if (drzava.startsWith("2"))
        {
            if (drzava.equals("21") || drzava.equals("26") || drzava.equals("29"))
            {
                textView_republika.setText("Crna Gora");
                imageView_drzava.setImageResource(R.drawable.flag_me);
            }
            if (drzava.equals("21"))
                textView_region.setText("Podgorica");
            if (drzava.equals("26"))
                textView_region.setText("Nikšić");
            if (drzava.equals("29"))
                textView_region.setText("Pljevlja");
        }

        //Hrvatska
        else if (drzava.startsWith("3"))
        {
            if (drzava.equals("30") || drzava.equals("31") || drzava.equals("32") || drzava.equals("33") || drzava.equals("34") || drzava.equals("35") || drzava.equals("36") || drzava.equals("37") || drzava.equals("38") || drzava.equals("39"))
            {
                textView_republika.setText("Hrvatska");
                imageView_drzava.setImageResource(R.drawable.flag_hr);
            }
            if (drzava.equals("30"))
                textView_region.setText("Osijek, Slavonija region");
            if (drzava.equals("31"))
                textView_region.setText("Bjelovar, Virovitica, Koprivnica, Pakrac, Podravina region");
            if (drzava.equals("32"))
                textView_region.setText("Varaždin, Međimurje region");
            if (drzava.equals("33"))
                textView_region.setText("Zagreb");
            if (drzava.equals("34"))
                textView_region.setText("Karlovac");
            if (drzava.equals("35"))
                textView_region.setText("Gospić, Lika region");
            if (drzava.equals("36"))
                textView_region.setText("Rijeka, Pula, Istra and Primorje regions");
            if (drzava.equals("37"))
                textView_region.setText("Sisak, Banovina region");
            if (drzava.equals("38"))
                textView_region.setText("Split, Zadar, Dubrovnik, Dalmacija region");
            if (drzava.equals("39"))
                textView_region.setText("mešano");
        }

        //Makedonija
        else if (drzava.startsWith("4"))
        {
            if (drzava.equals("41") || drzava.equals("42") || drzava.equals("43") || drzava.equals("44") || drzava.equals("45") || drzava.equals("46") || drzava.equals("47") || drzava.equals("48") || drzava.equals("49"))
            {
                textView_republika.setText("Makedonija");
                imageView_drzava.setImageResource(R.drawable.flag_mk);
            }
            if (drzava.equals("41"))
                textView_region.setText("Bitola");
            if (drzava.equals("42"))
                textView_region.setText("Kumanovo");
            if (drzava.equals("43"))
                textView_region.setText("Ohrid");
            if (drzava.equals("44"))
                textView_region.setText("Prilep");
            if (drzava.equals("45"))
                textView_region.setText("Skopje");
            if (drzava.equals("46"))
                textView_region.setText("Strumica");
            if (drzava.equals("47"))
                textView_region.setText("Tetovo");
            if (drzava.equals("48"))
                textView_region.setText("Veles");
            if (drzava.equals("49"))
                textView_region.setText("Štip");
        }

        //Slovenija
        else if (drzava.startsWith("5"))
        {
            if (drzava.equals("50"))
            {
                textView_republika.setText("Slovenija");
                imageView_drzava.setImageResource(R.drawable.flag_si);
            }
        }

        //Srbija
        else if (drzava.startsWith("7"))
        {
            if (drzava.equals("71") || drzava.equals("72") || drzava.equals("73") || drzava.equals("74") || drzava.equals("75") || drzava.equals("76") || drzava.equals("77") || drzava.equals("78") || drzava.equals("79"))
            {
                textView_republika.setText("Srbija");
                imageView_drzava.setImageResource(R.drawable.flag_rs);
            }
            if (drzava.equals("71"))
                textView_region.setText("Region Beograd");
            if (drzava.equals("72"))
                textView_region.setText("Region Šumadija i Pomoravlje");
            if (drzava.equals("73"))
                textView_region.setText("Niš region");
            if (drzava.equals("74"))
                textView_region.setText("Južna Morava region");
            if (drzava.equals("75"))
                textView_region.setText("Zaječar region");
            if (drzava.equals("76"))
                textView_region.setText("Podunavlje region");
            if (drzava.equals("77"))
                textView_region.setText("Podrinje i Kolubara region");
            if (drzava.equals("78"))
                textView_region.setText("Kraljevo region");
            if (drzava.equals("79"))
                textView_region.setText("Užice region");
        }

        //Autonomna Pokrajina Vojvodina
        else if (drzava.startsWith("8"))
        {
            if (drzava.equals("80") || drzava.equals("81") || drzava.equals("82") || drzava.equals("85") || drzava.equals("86") || drzava.equals("87") || drzava.equals("88") || drzava.equals("89"))
            {
                textView_republika.setText("Autonomna Pokrajina Vojvodina");
                imageView_drzava.setImageResource(R.drawable.flag_rs);
            }
            if (drzava.equals("80"))
                textView_region.setText("Novi Sad region");
            if (drzava.equals("81"))
                textView_region.setText("Sombor region");
            if (drzava.equals("82"))
                textView_region.setText("Subotica region");
            if (drzava.equals("85"))
                textView_region.setText("Zrenjanin region");
            if (drzava.equals("86"))
                textView_region.setText("Pančevo region");
            if (drzava.equals("87"))
                textView_region.setText("Kikinda region");
            if (drzava.equals("88"))
                textView_region.setText("Ruma region");
            if (drzava.equals("89"))
                textView_region.setText("Sremska Mitrovica region");
        }

        //Autonomna Pokrajina Kosovo i Metohija
        else if (drzava.startsWith("9"))
        {
            if (drzava.equals("91") || drzava.equals("92") || drzava.equals("93") || drzava.equals("94") || drzava.equals("95") || drzava.equals("96"))
            {
                textView_republika.setText("Autonomna Pokrajina Kosovo i Metohija");
                imageView_drzava.setImageResource(R.drawable.flag_rs);
            }
            if (drzava.equals("91"))
                textView_region.setText("Priština region");
            if (drzava.equals("92"))
                textView_region.setText("Kosovska Mitrovica region");
            if (drzava.equals("93"))
                textView_region.setText("Peć region");
            if (drzava.equals("94"))
                textView_region.setText("Đakovica region");
            if (drzava.equals("95"))
                textView_region.setText("Prizren region");
            if (drzava.equals("96"))
                textView_region.setText("Kosovsko Pomoravski okrug");
        } else
        {
            editText1.setTextColor(Color.RED);
            Toast.makeText(MainActivity.this, "Pogresna drzava", Toast.LENGTH_SHORT).show();
            return;
        }
    }

    private void provera_pol(int muski_pol,int zenski_pol)
    {
        muski_pol = Integer.parseInt(editText1.getText().toString().substring(9, editText1.getText().length() - 1));
        zenski_pol = Integer.parseInt(editText1.getText().toString().substring(9, editText1.getText().length() - 1));

        if (muski_pol >= 0 && muski_pol <= 499)
        {
            textView_pol.setText("Muski");
            textView_redni_broj.setText(String.valueOf(muski_pol));
        } else if (zenski_pol >= 500 && zenski_pol <= 999)
        {
            textView_pol.setText("Ženski");
            textView_redni_broj.setText(String.valueOf(zenski_pol));
        } else
        {
            editText1.setTextColor(Color.RED);
            Toast.makeText(MainActivity.this, "Pogresan pol", Toast.LENGTH_SHORT).show();
        }
    }

    private void kontrolni_broj(int kontrolna_cifra)
    {
        try
        {
            A = Integer.parseInt(editText1.getText().toString().substring(0, editText1.getText().length() - 12));
            B = Integer.parseInt(editText1.getText().toString().substring(1, editText1.getText().length() - 11));
            V = Integer.parseInt(editText1.getText().toString().substring(2, editText1.getText().length() - 10));
            G = Integer.parseInt(editText1.getText().toString().substring(3, editText1.getText().length() - 9));
            D = Integer.parseInt(editText1.getText().toString().substring(4, editText1.getText().length() - 8));
            Đ = Integer.parseInt(editText1.getText().toString().substring(5, editText1.getText().length() - 7));
            E = Integer.parseInt(editText1.getText().toString().substring(6, editText1.getText().length() - 6));
            Ž = Integer.parseInt(editText1.getText().toString().substring(7, editText1.getText().length() - 5));
            Z = Integer.parseInt(editText1.getText().toString().substring(8, editText1.getText().length() - 4));
            I = Integer.parseInt(editText1.getText().toString().substring(9, editText1.getText().length() - 3));
            J = Integer.parseInt(editText1.getText().toString().substring(10, editText1.getText().length() - 2));
            K = Integer.parseInt(editText1.getText().toString().substring(11, editText1.getText().length() - 1));
            L = Integer.parseInt(editText1.getText().toString().substring(12, editText1.getText().length() - 0));

            kontrolna_cifra = 11 - ((7 * (A + E) + 6 * (B + Ž) + 5 * (V + Z) + 4 * (G + I) + 3 * (D + J) + 2 * (Đ + K)) % 11);

            if (kontrolna_cifra <= 9)
            {
                if (kontrolna_cifra != L)
                {
                    Toast.makeText(MainActivity.this,"Kontrolna cifra treba da bude: " + kontrolna_cifra,Toast.LENGTH_SHORT).show();
                    //editText1.setText("");
                    imageView_drzava.setImageResource(0);
                    textView_republika.setText("");
                    textView_region.setText("");
                    textView_datum.setText("");
                    textView_pol.setText("");
                    textView_redni_broj.setText("");
                    button_okrug.setEnabled(false);
                    editText1.requestFocus();

                    return;
                }
            } else if (kontrolna_cifra > 9)
            {
                if (L != 0)
                {
                    //Toast.makeText(MainActivity.this, "JMBG Nije dobar.Kontrolna cifra se ne slaze!", Toast.LENGTH_SHORT).show();
                    Toast.makeText(MainActivity.this,"Kontrolna cifra treba da bude: " + kontrolna_cifra,Toast.LENGTH_SHORT).show();
                    //editText1.setText("");
                    imageView_drzava.setImageResource(0);
                    textView_republika.setText("");
                    textView_region.setText("");
                    textView_datum.setText("");
                    textView_pol.setText("");
                    textView_redni_broj.setText("");
                    button_okrug.setEnabled(false);
                    editText1.requestFocus();

                    return;
                }
            } else
            {
                //Toast.makeText(MainActivity.this, "JMBG Nije dobar.Kontrolna cifra se ne slaze!", Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this,"Kontrolna cifra treba da bude: " + kontrolna_cifra,Toast.LENGTH_SHORT).show();
                //editText1.setText("");
                imageView_drzava.setImageResource(0);
                textView_republika.setText("");
                textView_region.setText("");
                textView_datum.setText("");
                textView_pol.setText("");
                textView_redni_broj.setText("");
                button_okrug.setEnabled(false);
                editText1.requestFocus();

                return;
            }
        }
        catch(StringIndexOutOfBoundsException e)
        {
            System.out.println("StringIndexOutOfBoundsException!!");
        }
    }
}
