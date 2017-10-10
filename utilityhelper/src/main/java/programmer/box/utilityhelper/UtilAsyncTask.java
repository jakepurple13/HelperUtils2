package programmer.box.utilityhelper;

import android.os.AsyncTask;

/**
 * Created by Jacob on 10/10/17.
 */

public abstract class UtilAsyncTask extends AsyncTask<Void, Integer, Boolean> {

    abstract void onPreExecutes();

    abstract boolean onBackgrounds(Void... voids);

    abstract void onPostExecutes(Boolean o);

    abstract void onProgressUpdates(Integer[] values);

    public void updateProgress(Integer... values) {
        publishProgress(values);
    }

    @Override
    protected void onPostExecute(Boolean o) {
        super.onPostExecute(o);
        onPostExecutes(o);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        onPreExecutes();
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
