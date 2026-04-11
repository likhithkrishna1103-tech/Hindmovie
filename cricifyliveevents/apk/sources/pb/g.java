package pb;

import android.util.Log;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Charset f10158b = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final tb.c f10159a;

    public g(tb.c cVar) {
        this.f10159a = cVar;
    }

    public static HashMap a(String str) {
        JSONObject jSONObject = new JSONObject(str);
        HashMap map = new HashMap();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            String strOptString = null;
            if (!jSONObject.isNull(next)) {
                strOptString = jSONObject.optString(next, null);
            }
            map.put(next, strOptString);
        }
        return map;
    }

    public static ArrayList b(String str) throws JSONException {
        JSONArray jSONArray = new JSONObject(str).getJSONArray("rolloutsState");
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            String string = jSONArray.getString(i);
            try {
                p6.c cVar = m.f10174a;
                JSONObject jSONObject = new JSONObject(string);
                String string2 = jSONObject.getString("rolloutId");
                String string3 = jSONObject.getString("parameterKey");
                String string4 = jSONObject.getString("parameterValue");
                String string5 = jSONObject.getString("variantId");
                long j4 = jSONObject.getLong("templateVersion");
                if (string4.length() > 256) {
                    string4 = string4.substring(0, 256);
                }
                arrayList.add(new b(string2, string3, string4, string5, j4));
            } catch (Exception e9) {
                Log.w("FirebaseCrashlytics", "Failed de-serializing rollouts state. " + string, e9);
            }
        }
        return arrayList;
    }

    public static String e(List list) {
        HashMap map = new HashMap();
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < list.size(); i++) {
            try {
                jSONArray.put(new JSONObject(m.f10174a.g(list.get(i))));
            } catch (JSONException e9) {
                Log.w("FirebaseCrashlytics", "Exception parsing rollout assignment!", e9);
            }
        }
        map.put("rolloutsState", jSONArray);
        return new JSONObject(map).toString();
    }

    public static void f(File file) {
        if (file.exists() && file.delete()) {
            Log.i("FirebaseCrashlytics", "Deleted corrupt file: " + file.getAbsolutePath(), null);
        }
    }

    public static void g(File file, String str) {
        if (file.exists() && file.delete()) {
            Log.i("FirebaseCrashlytics", "Deleted corrupt file: " + file.getAbsolutePath() + "\nReason: " + str, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.io.Closeable] */
    public final Map c(String str, boolean z10) throws Throwable {
        Throwable th;
        FileInputStream fileInputStream;
        Exception e9;
        tb.c cVar = this.f10159a;
        File fileB = z10 ? cVar.b(str, "internal-keys") : cVar.b(str, "keys");
        if (!fileB.exists() || fileB.length() == 0) {
            g(fileB, "The file has a length of zero for session: " + str);
            return Collections.EMPTY_MAP;
        }
        try {
            try {
                fileInputStream = new FileInputStream(fileB);
                try {
                    HashMap mapA = a(nb.f.i(fileInputStream));
                    nb.f.b(fileInputStream, "Failed to close user metadata file.");
                    return mapA;
                } catch (Exception e10) {
                    e9 = e10;
                    Log.w("FirebaseCrashlytics", "Error deserializing user metadata.", e9);
                    f(fileB);
                    nb.f.b(fileInputStream, "Failed to close user metadata file.");
                    return Collections.EMPTY_MAP;
                }
            } catch (Throwable th2) {
                th = th2;
                nb.f.b(, "Failed to close user metadata file.");
                throw th;
            }
        } catch (Exception e11) {
            fileInputStream = null;
            e9 = e11;
        } catch (Throwable th3) {
            ?? r12 = 0;
            th = th3;
            nb.f.b(r12, "Failed to close user metadata file.");
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [int] */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.io.Closeable] */
    public final String d(String str) throws Throwable {
        FileInputStream fileInputStream;
        File fileB = this.f10159a.b(str, "user-data");
        ?? r62 = 0;
        if (fileB.exists()) {
            ?? r32 = (fileB.length() > 0L ? 1 : (fileB.length() == 0L ? 0 : -1));
            try {
                if (r32 != 0) {
                    try {
                        fileInputStream = new FileInputStream(fileB);
                        try {
                            JSONObject jSONObject = new JSONObject(nb.f.i(fileInputStream));
                            String strOptString = !jSONObject.isNull("userId") ? jSONObject.optString("userId", null) : null;
                            String str2 = "Loaded userId " + strOptString + " for session " + str;
                            if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                                Log.d("FirebaseCrashlytics", str2, null);
                            }
                            nb.f.b(fileInputStream, "Failed to close user metadata file.");
                            return strOptString;
                        } catch (Exception e9) {
                            e = e9;
                            Log.w("FirebaseCrashlytics", "Error deserializing user metadata.", e);
                            f(fileB);
                            nb.f.b(fileInputStream, "Failed to close user metadata file.");
                            return null;
                        }
                    } catch (Exception e10) {
                        e = e10;
                        fileInputStream = null;
                    } catch (Throwable th) {
                        th = th;
                        nb.f.b(r62, "Failed to close user metadata file.");
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                r62 = r32;
            }
        }
        String strN = q4.a.n("No userId set for session ", str);
        if (Log.isLoggable("FirebaseCrashlytics", 3)) {
            Log.d("FirebaseCrashlytics", strN, null);
        }
        f(fileB);
        return null;
    }

    public final void h(String str, Map map, boolean z10) {
        String string;
        BufferedWriter bufferedWriter;
        tb.c cVar = this.f10159a;
        File fileB = z10 ? cVar.b(str, "internal-keys") : cVar.b(str, "keys");
        BufferedWriter bufferedWriter2 = null;
        try {
            try {
                string = new JSONObject(map).toString();
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileB), f10158b));
            } catch (Exception e9) {
                e = e9;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            bufferedWriter.write(string);
            bufferedWriter.flush();
            nb.f.b(bufferedWriter, "Failed to close key/value metadata file.");
        } catch (Exception e10) {
            e = e10;
            bufferedWriter2 = bufferedWriter;
            Log.w("FirebaseCrashlytics", "Error serializing key/value metadata.", e);
            f(fileB);
            nb.f.b(bufferedWriter2, "Failed to close key/value metadata file.");
        } catch (Throwable th2) {
            th = th2;
            bufferedWriter2 = bufferedWriter;
            nb.f.b(bufferedWriter2, "Failed to close key/value metadata file.");
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.Closeable] */
    public final void i(String str, List list) {
        Throwable th;
        BufferedWriter bufferedWriter;
        Exception e9;
        File fileB = this.f10159a.b(str, "rollouts-state");
        ?? IsEmpty = list.isEmpty();
        if (IsEmpty != 0) {
            g(fileB, "Rollout state is empty for session: " + str);
            return;
        }
        try {
            try {
                String strE = e(list);
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileB), f10158b));
                try {
                    bufferedWriter.write(strE);
                    bufferedWriter.flush();
                    nb.f.b(bufferedWriter, "Failed to close rollouts state file.");
                } catch (Exception e10) {
                    e9 = e10;
                    Log.w("FirebaseCrashlytics", "Error serializing rollouts state.", e9);
                    f(fileB);
                    nb.f.b(bufferedWriter, "Failed to close rollouts state file.");
                }
            } catch (Throwable th2) {
                th = th2;
                nb.f.b(IsEmpty, "Failed to close rollouts state file.");
                throw th;
            }
        } catch (Exception e11) {
            bufferedWriter = null;
            e9 = e11;
        } catch (Throwable th3) {
            IsEmpty = 0;
            th = th3;
            nb.f.b(IsEmpty, "Failed to close rollouts state file.");
            throw th;
        }
    }
}
