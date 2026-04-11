package kc;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.JsonReader;
import android.util.Log;
import fc.f;
import ic.e;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.concurrent.ExecutionException;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
import o8.u;
import org.json.JSONException;
import org.json.JSONObject;
import vf.g;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Pattern f7408d = Pattern.compile("[0-9]+s");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Charset f7409e = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f7410a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final hc.b f7411b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f7412c = new d();

    public c(Context context, hc.b bVar) {
        this.f7410a = context;
        this.f7411b = bVar;
    }

    public static URL a(String str) {
        try {
            return new URL("https://firebaseinstallations.googleapis.com/v1/" + str);
        } catch (MalformedURLException e9) {
            throw new e(e9.getMessage());
        }
    }

    public static void b(HttpURLConnection httpURLConnection, String str, String str2, String str3) {
        StringBuilder sb;
        InputStream errorStream = httpURLConnection.getErrorStream();
        String str4 = null;
        if (errorStream != null) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(errorStream, f7409e));
            try {
                sb = new StringBuilder();
            } catch (IOException unused) {
            } catch (Throwable th) {
                try {
                    bufferedReader.close();
                } catch (IOException unused2) {
                }
                throw th;
            }
            try {
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    sb.append(line);
                    sb.append('\n');
                    bufferedReader.close();
                }
                bufferedReader.close();
            } catch (IOException unused3) {
            }
            str4 = String.format("Error when communicating with the Firebase Installations server API. HTTP response: [%d %s: %s]", Integer.valueOf(httpURLConnection.getResponseCode()), httpURLConnection.getResponseMessage(), sb);
        }
        if (TextUtils.isEmpty(str4)) {
            return;
        }
        Log.w("Firebase-Installations", str4);
        Log.w("Firebase-Installations", "Firebase options used while communicating with Firebase server APIs: " + str2 + ", " + str3 + (TextUtils.isEmpty(str) ? "" : q4.a.n(", ", str)));
    }

    public static long d(String str) {
        u.a("Invalid Expiration Timestamp.", f7408d.matcher(str).matches());
        if (str == null || str.length() == 0) {
            return 0L;
        }
        return Long.parseLong(str.substring(0, str.length() - 1));
    }

    public static a e(HttpURLConnection httpURLConnection) throws IOException {
        InputStream inputStream = httpURLConnection.getInputStream();
        JsonReader jsonReader = new JsonReader(new InputStreamReader(inputStream, f7409e));
        byte b8 = (byte) (0 | 1);
        jsonReader.beginObject();
        String strNextString = null;
        String strNextString2 = null;
        b bVar = null;
        long jD = 0;
        String strNextString3 = null;
        String strNextString4 = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            if (strNextName.equals("name")) {
                strNextString3 = jsonReader.nextString();
            } else if (strNextName.equals("fid")) {
                strNextString4 = jsonReader.nextString();
            } else if (strNextName.equals("refreshToken")) {
                strNextString2 = jsonReader.nextString();
            } else if (strNextName.equals("authToken")) {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    String strNextName2 = jsonReader.nextName();
                    if (strNextName2.equals("token")) {
                        strNextString = jsonReader.nextString();
                    } else if (strNextName2.equals("expiresIn")) {
                        b8 = (byte) (b8 | 1);
                        jD = d(jsonReader.nextString());
                    } else {
                        jsonReader.skipValue();
                    }
                }
                if (b8 != 1) {
                    throw new IllegalStateException("Missing required properties: tokenExpirationTimestamp");
                }
                bVar = new b(0, jD, strNextString);
                jsonReader.endObject();
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        jsonReader.close();
        inputStream.close();
        return new a(strNextString3, strNextString4, strNextString2, bVar, 1);
    }

    public static b f(HttpURLConnection httpURLConnection) throws IOException {
        InputStream inputStream = httpURLConnection.getInputStream();
        JsonReader jsonReader = new JsonReader(new InputStreamReader(inputStream, f7409e));
        byte b8 = (byte) (0 | 1);
        jsonReader.beginObject();
        String strNextString = null;
        long jD = 0;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            if (strNextName.equals("token")) {
                strNextString = jsonReader.nextString();
            } else if (strNextName.equals("expiresIn")) {
                jD = d(jsonReader.nextString());
                b8 = (byte) (b8 | 1);
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        jsonReader.close();
        inputStream.close();
        if (b8 == 1) {
            return new b(1, jD, strNextString);
        }
        throw new IllegalStateException("Missing required properties: tokenExpirationTimestamp");
    }

    public static void g(HttpURLConnection httpURLConnection, String str, String str2) throws IOException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("fid", str);
            jSONObject.put("appId", str2);
            jSONObject.put("authVersion", "FIS_v2");
            jSONObject.put("sdkVersion", "a:19.1.0");
            i(httpURLConnection, jSONObject.toString().getBytes("UTF-8"));
        } catch (JSONException e9) {
            throw new IllegalStateException(e9);
        }
    }

    public static void h(HttpURLConnection httpURLConnection) throws IOException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("sdkVersion", "a:19.1.0");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("installation", jSONObject);
            i(httpURLConnection, jSONObject2.toString().getBytes("UTF-8"));
        } catch (JSONException e9) {
            throw new IllegalStateException(e9);
        }
    }

    public static void i(HttpURLConnection httpURLConnection, byte[] bArr) throws IOException {
        OutputStream outputStream = httpURLConnection.getOutputStream();
        if (outputStream == null) {
            throw new IOException("Cannot send request to FIS servers. No OutputStream available.");
        }
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
        try {
            gZIPOutputStream.write(bArr);
        } finally {
            try {
                gZIPOutputStream.close();
                outputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    public final HttpURLConnection c(URL url, String str) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.addRequestProperty("Content-Type", "application/json");
            httpURLConnection.addRequestProperty("Accept", "application/json");
            httpURLConnection.addRequestProperty("Content-Encoding", "gzip");
            httpURLConnection.addRequestProperty("Cache-Control", "no-cache");
            Context context = this.f7410a;
            httpURLConnection.addRequestProperty("X-Android-Package", context.getPackageName());
            f fVar = (f) this.f7411b.get();
            if (fVar != null) {
                try {
                    httpURLConnection.addRequestProperty("x-firebase-client", (String) g.b(((fc.d) fVar).b()));
                } catch (InterruptedException e9) {
                    Thread.currentThread().interrupt();
                    Log.w("ContentValues", "Failed to get heartbeats header", e9);
                } catch (ExecutionException e10) {
                    Log.w("ContentValues", "Failed to get heartbeats header", e10);
                }
            }
            String strA = null;
            try {
                byte[] bArrC = s8.b.c(context, context.getPackageName());
                if (bArrC == null) {
                    Log.e("ContentValues", "Could not get fingerprint hash for package: " + context.getPackageName());
                } else {
                    strA = s8.b.a(bArrC);
                }
            } catch (PackageManager.NameNotFoundException e11) {
                Log.e("ContentValues", "No such package: " + context.getPackageName(), e11);
            }
            httpURLConnection.addRequestProperty("X-Android-Cert", strA);
            httpURLConnection.addRequestProperty("x-goog-api-key", str);
            return httpURLConnection;
        } catch (IOException unused) {
            throw new e("Firebase Installations Service is unavailable. Please try again later.");
        }
    }
}
