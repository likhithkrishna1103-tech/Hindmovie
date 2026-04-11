package g6;

import android.util.Log;
import androidx.media3.decoder.DecoderInputBuffer;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.NavigableSet;
import java.util.concurrent.Callable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class k implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5104a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f5105b;

    public /* synthetic */ k(int i, Object obj) {
        this.f5104a = i;
        this.f5105b = obj;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        rc.e eVarA;
        FileInputStream fileInputStreamOpenFileInput;
        Throwable th;
        switch (this.f5104a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return n.d((ByteArrayInputStream) this.f5105b, null);
            case 1:
                nb.l lVar = ((nb.p) this.f5105b).f8983g;
                lVar.getClass();
                ob.c.a();
                i2.k kVar = lVar.f8957c;
                tb.c cVar = (tb.c) kVar.f6086w;
                String str = (String) kVar.f6085v;
                cVar.getClass();
                boolean z10 = true;
                if (new File((File) cVar.f11985x, str).exists()) {
                    if (Log.isLoggable("FirebaseCrashlytics", 2)) {
                        Log.v("FirebaseCrashlytics", "Found previous crash marker.", null);
                    }
                    tb.c cVar2 = (tb.c) kVar.f6086w;
                    cVar2.getClass();
                    new File((File) cVar2.f11985x, str).delete();
                } else {
                    NavigableSet navigableSetC = ((tb.a) lVar.f8965m.f2036c).c();
                    String str2 = navigableSetC.isEmpty() ? null : (String) navigableSetC.first();
                    if (str2 == null || !lVar.f8962j.c(str2)) {
                        z10 = false;
                    }
                }
                return Boolean.valueOf(z10);
            case 2:
                return ((qc.i) this.f5105b).a();
            case 3:
                rc.m mVar = (rc.m) this.f5105b;
                synchronized (mVar) {
                    eVarA = null;
                    try {
                        fileInputStreamOpenFileInput = mVar.f10988a.openFileInput(mVar.f10989b);
                    } catch (FileNotFoundException | JSONException unused) {
                        fileInputStreamOpenFileInput = null;
                    } catch (Throwable th2) {
                        fileInputStreamOpenFileInput = null;
                        th = th2;
                    }
                    try {
                        int iAvailable = fileInputStreamOpenFileInput.available();
                        byte[] bArr = new byte[iAvailable];
                        fileInputStreamOpenFileInput.read(bArr, 0, iAvailable);
                        eVarA = rc.e.a(new JSONObject(new String(bArr, "UTF-8")));
                        fileInputStreamOpenFileInput.close();
                    } catch (FileNotFoundException | JSONException unused2) {
                        if (fileInputStreamOpenFileInput != null) {
                            fileInputStreamOpenFileInput.close();
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        if (fileInputStreamOpenFileInput != null) {
                            fileInputStreamOpenFileInput.close();
                        }
                        throw th;
                    }
                    break;
                }
                return eVarA;
            default:
                d8.j jVar = (d8.j) ((vb.b) this.f5105b).f13552x;
                m2.e eVar = (m2.e) jVar.f;
                vb.d dVar = (vb.d) jVar.f3552b;
                String str3 = (String) eVar.f8050v;
                ob.c.b();
                try {
                    HashMap mapS = m2.e.s(dVar);
                    l7.a aVar = new l7.a(str3, mapS);
                    aVar.z("User-Agent", "Crashlytics Android SDK/20.0.4");
                    aVar.z("X-CRASHLYTICS-DEVELOPER-TOKEN", "470fa2b4ae81cd56ecbcda9735803434cec591fa");
                    m2.e.m(aVar, dVar);
                    String str4 = "Requesting settings from " + str3;
                    if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                        Log.d("FirebaseCrashlytics", str4, null);
                    }
                    String str5 = "Settings query params were: " + mapS;
                    if (Log.isLoggable("FirebaseCrashlytics", 2)) {
                        Log.v("FirebaseCrashlytics", str5, null);
                    }
                    return eVar.u(aVar.p());
                } catch (IOException e9) {
                    Log.e("FirebaseCrashlytics", "Settings request failed.", e9);
                    return null;
                }
        }
    }
}
