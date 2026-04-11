package lb;

import android.util.Base64OutputStream;
import androidx.media3.decoder.DecoderInputBuffer;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8074a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f8075b;

    public /* synthetic */ c(d dVar, int i) {
        this.f8074a = i;
        this.f8075b = dVar;
    }

    private final Object a() {
        String string;
        d dVar = this.f8075b;
        synchronized (dVar) {
            try {
                u5.d dVar2 = (u5.d) dVar.f8076a.get();
                ArrayList arrayListK = dVar2.K();
                dVar2.H();
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < arrayListK.size(); i++) {
                    a aVar = (a) arrayListK.get(i);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("agent", aVar.f8070a);
                    jSONObject.put("dates", new JSONArray((Collection) aVar.f8071b));
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
        switch (this.f8074a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return a();
            default:
                d dVar = this.f8075b;
                synchronized (dVar) {
                    ((u5.d) dVar.f8076a.get()).V(((wb.b) dVar.f8078c.get()).a(), System.currentTimeMillis());
                    break;
                }
                return null;
        }
    }
}
