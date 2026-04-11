package bb;

import android.util.Log;
import androidx.media3.decoder.DecoderInputBuffer;
import b7.s;
import com.google.android.gms.internal.measurement.k4;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.NavigableSet;
import java.util.concurrent.Callable;
import l5.n;
import org.json.JSONException;
import org.json.JSONObject;
import ta.m;
import ta.q;
import xb.i;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1985a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1986b;

    public /* synthetic */ d(int i, Object obj) {
        this.f1985a = i;
        this.f1986b = obj;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        yb.e eVarA;
        FileInputStream fileInputStreamOpenFileInput;
        Throwable th;
        switch (this.f1985a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                s sVar = (s) ((k4) this.f1986b).f3071v;
                a aVar = (a) sVar.f;
                f fVar = (f) sVar.f1899b;
                String str = aVar.f1976a;
                ua.d.b();
                try {
                    HashMap mapB = a.b(fVar);
                    kc.b bVar = new kc.b(str, mapB);
                    bVar.x("User-Agent", "Crashlytics Android SDK/19.2.0");
                    bVar.x("X-CRASHLYTICS-DEVELOPER-TOKEN", "470fa2b4ae81cd56ecbcda9735803434cec591fa");
                    a.a(bVar, fVar);
                    String str2 = "Requesting settings from " + str;
                    if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                        Log.d("FirebaseCrashlytics", str2, null);
                    }
                    String str3 = "Settings query params were: " + mapB;
                    if (Log.isLoggable("FirebaseCrashlytics", 2)) {
                        Log.v("FirebaseCrashlytics", str3, null);
                    }
                    return aVar.c(bVar.o());
                } catch (IOException e10) {
                    Log.e("FirebaseCrashlytics", "Settings request failed.", e10);
                    return null;
                }
            case 1:
                return n.c((ByteArrayInputStream) this.f1986b, null);
            case 2:
                m mVar = ((q) this.f1986b).f12409g;
                mVar.getClass();
                ua.d.a();
                p2.c cVar = mVar.f12383c;
                za.c cVar2 = (za.c) cVar.f10131w;
                String str4 = (String) cVar.f10130v;
                cVar2.getClass();
                boolean z2 = true;
                if (new File((File) cVar2.f14936c, str4).exists()) {
                    if (Log.isLoggable("FirebaseCrashlytics", 2)) {
                        Log.v("FirebaseCrashlytics", "Found previous crash marker.", null);
                    }
                    za.c cVar3 = (za.c) cVar.f10131w;
                    cVar3.getClass();
                    new File((File) cVar3.f14936c, str4).delete();
                } else {
                    NavigableSet navigableSetC = ((za.a) mVar.f12391m.f1738c).c();
                    String str5 = navigableSetC.isEmpty() ? null : (String) navigableSetC.first();
                    if (str5 == null || !mVar.f12388j.c(str5)) {
                        z2 = false;
                    }
                }
                return Boolean.valueOf(z2);
            case 3:
                return ((i) this.f1986b).a();
            default:
                yb.n nVar = (yb.n) this.f1986b;
                synchronized (nVar) {
                    eVarA = null;
                    try {
                        fileInputStreamOpenFileInput = nVar.f14638a.openFileInput(nVar.f14639b);
                        try {
                            int iAvailable = fileInputStreamOpenFileInput.available();
                            byte[] bArr = new byte[iAvailable];
                            fileInputStreamOpenFileInput.read(bArr, 0, iAvailable);
                            eVarA = yb.e.a(new JSONObject(new String(bArr, "UTF-8")));
                            fileInputStreamOpenFileInput.close();
                        } catch (FileNotFoundException | JSONException unused) {
                            if (fileInputStreamOpenFileInput != null) {
                                fileInputStreamOpenFileInput.close();
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (fileInputStreamOpenFileInput != null) {
                                fileInputStreamOpenFileInput.close();
                            }
                            throw th;
                        }
                    } catch (FileNotFoundException | JSONException unused2) {
                        fileInputStreamOpenFileInput = null;
                    } catch (Throwable th3) {
                        fileInputStreamOpenFileInput = null;
                        th = th3;
                    }
                }
                return eVarA;
        }
    }
}
