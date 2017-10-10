package programmer.box.utilityhelper;

import android.app.Dialog;
import android.os.AsyncTask;

/**
 * Created by Jacob on 10/10/17.
 */

public abstract class UtilAsyncTask extends AsyncTask<Void, Integer, Boolean> {

    public Dialog dialog;

    public UtilAsyncTask(Dialog dialog) {
        this.dialog = dialog;
    }

    public UtilAsyncTask() {

    }

    public abstract void onPreExecutes();

    public abstract boolean onBackgrounds(Void... voids);

    public abstract void onPostExecutes(Boolean o);

    public abstract void onProgressUpdates(Integer[] values);

    public void updateProgress(Integer... values) {
        publishProgress(values);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        if(dialog != null) {
            dialog.show();
        }
        onPreExecutes();
    }

    @Override
    protected void onPostExecute(Boolean o) {
        super.onPostExecute(o);
        if(o) {
            if (dialog != null) {
                dialog.dismiss();
            }
        }
        onPostExecutes(o);
    }

    @Override
    protected void onProgressUpdate(Integer[] values) {
        super.onProgressUpdate(values);
        onProgressUpdates(values);
    }

    @Override
    protected Boolean doInBackground(Void... voids) {
        return onBackgrounds(voids);
    }

    public UtilAsyncTask startTask(Void... params) {
        execute(params);
        return this;
    }

}