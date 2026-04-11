package fc;

import android.util.Base64OutputStream;
import androidx.media3.decoder.DecoderInputBuffer;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4539a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f4540b;

    public /* synthetic */ c(d dVar, int i) {
        this.f4539a = i;
        this.f4540b = dVar;
    }

    private final Object a() {
        String string;
        d dVar = this.f4540b;
        synchronized (dVar) {
            try {
                j jVar = (j) dVar.f4541a.get();
                ArrayList arrayListC = jVar.c();
                jVar.b();
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < arrayListC.size(); i++) {
                    a aVar = (a) arrayListC.get(i);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("agent", aVar.f4535a);
                    jSONObject.put("dates", new JSONArray((Collection) aVar.f4536b));
                    jSONArray.put(jSONObject);
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("heartbeats", jSONArray);
                jSONObject2.put("version", "2");
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                Base64OutputStream base64OutputStream = new Base64OutputStream(byteArrayOutputStream, 11);
                try {
                    GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(base64OutputStream);
                    try {
                        gZIPOutputStream.write(jSONObject2.toString().getBytes("UTF-8"));
                        gZIPOutputStream.close();
                        base64OutputStream.close();
                        string = byteArrayOutputStream.toString("UTF-8");
                    } finally {
                    }
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return string;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f4539a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return a();
            default:
                d dVar = this.f4540b;
                synchronized (dVar) {
                    ((j) dVar.f4541a.get()).k(((pc.b) dVar.f4543c.get()).a(), System.currentTimeMillis());
                    break;
                }
                return null;
        }
    }
}
