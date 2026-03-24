package com.example.myapp10test.pojo;


import android.content.Context;
import android.os.AsyncTask;//-----------SEND MAIL ASYNC Task-------------\\
import android.widget.Toast;


import java.net.PasswordAuthentication;
import java.util.Properties;


import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;


public class SendMail extends AsyncTask<Void, Void, Void> {

        //Declaring Variables
        private Context context;
        private Session session;

        //Information to send email
        private String email;
        private String subject;
        private String message;
        private String pwd= "secret";

        //ProgressDialog to show while sending email
//        private ProgressDialog progressDialog;
        //private ACProgressFlower progressDialog;

        //Class Constructor
        public SendMail(Context context, String email, String subject, String message) {
            //Initializing variables
            this.context = context;
            this.email = email;
            this.subject = subject;
            this.message = message;

        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //Showing progress dialog while sending email
//            progressDialog = ProgressDialog.show(context, "Sending message", "Please wait...", false, false);

        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            //Dismissing the progress dialog
            //progressDialog.dismiss();
            //Showing a success message
            Toast.makeText(context, "Poll emailed", Toast.LENGTH_LONG).show();
        }

        @Override
        protected Void doInBackground(Void... params) {
            //Creating properties
            Properties props = new Properties();

            //Configuring properties for gmail
            //If you are not using gmail you may need to change the values
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");
            //Creating a new session
            session = Session.getDefaultInstance(props,
                    new Authenticator() {
                        //Authenticating the password
                        protected jakarta.mail.PasswordAuthentication getPasswordAuthentication() {

                            return new jakarta.mail.PasswordAuthentication(email,pwd);
                        }
                    });

            try {
                //Creating MimeMessage object
                MimeMessage mm = new MimeMessage(session);

                //Setting sender address
                mm.setFrom(new InternetAddress(email));
                //Adding receiver
                mm.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
                //Adding subject
                mm.setSubject(subject);
                //Adding message
                mm.setText(message);

                //Sending email
                Transport.send(mm);

            } catch (MessagingException e) {
                e.printStackTrace();
            }
            return null;
        }
    }


    //------------------Send Mail using JavaX Mail API----------------------\\

//------------------------

