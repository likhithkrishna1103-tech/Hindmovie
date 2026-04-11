package l5;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Log;
import androidx.media3.decoder.DecoderInputBuffer;
import com.airbnb.lottie.LottieAnimationView;
import java.io.FileOutputStream;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7831a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f7832b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f7833c;

    public /* synthetic */ d(Object obj, int i, Object obj2) {
        this.f7831a = i;
        this.f7832b = obj;
        this.f7833c = obj2;
    }

    private final Object a() {
        String str;
        ServiceInfo serviceInfo;
        String str2;
        int i;
        ComponentName componentNameStartService;
        Context context = (Context) this.f7832b;
        Intent intent = (Intent) this.f7833c;
        ub.o oVarZ = ub.o.z();
        oVarZ.getClass();
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Starting service");
        }
        ((ArrayDeque) oVarZ.f12871y).offer(intent);
        Intent intent2 = new Intent("com.google.firebase.MESSAGING_EVENT");
        intent2.setPackage(context.getPackageName());
        synchronized (oVarZ) {
            try {
                str = (String) oVarZ.f12868v;
                if (str == null) {
                    ResolveInfo resolveInfoResolveService = context.getPackageManager().resolveService(intent2, 0);
                    if (resolveInfoResolveService == null || (serviceInfo = resolveInfoResolveService.serviceInfo) == null) {
                        Log.e("FirebaseMessaging", "Failed to resolve target intent service, skipping classname enforcement");
                    } else {
                        if (context.getPackageName().equals(serviceInfo.packageName) && (str2 = serviceInfo.name) != null) {
                            if (str2.startsWith(".")) {
                                oVarZ.f12868v = context.getPackageName() + serviceInfo.name;
                            } else {
                                oVarZ.f12868v = serviceInfo.name;
                            }
                            str = (String) oVarZ.f12868v;
                        }
                        Log.e("FirebaseMessaging", "Error resolving target intent service, skipping classname enforcement. Resolved service was: " + serviceInfo.packageName + "/" + serviceInfo.name);
                    }
                    str = null;
                }
            } finally {
            }
        }
        if (str != null) {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "Restricting intent to a specific service: ".concat(str));
            }
            intent2.setClassName(context.getPackageName(), str);
        }
        try {
            if (oVarZ.E(context)) {
                componentNameStartService = ub.w.d(context, intent2);
            } else {
                componentNameStartService = context.startService(intent2);
                Log.d("FirebaseMessaging", "Missing wake lock permission, service start may be delayed");
            }
            if (componentNameStartService == null) {
                Log.e("FirebaseMessaging", "Error while delivering the message: ServiceIntent not found.");
                i = 404;
            } else {
                i = -1;
            }
        } catch (IllegalStateException e10) {
            Log.e("FirebaseMessaging", "Failed to start service while in background: " + e10);
            i = 402;
        } catch (SecurityException e11) {
            Log.e("FirebaseMessaging", "Error while delivering the message to the serviceIntent", e11);
            i = 401;
        }
        return Integer.valueOf(i);
    }

    private final Object b() {
        xb.b bVar = (xb.b) this.f7832b;
        w2.s sVar = (w2.s) this.f7833c;
        yb.j jVar = bVar.i;
        synchronized (jVar.f14616b) {
            SharedPreferences.Editor editorEdit = jVar.f14615a.edit();
            sVar.getClass();
            editorEdit.putLong("fetch_timeout_in_seconds", 60L).putLong("minimum_fetch_interval_in_seconds", sVar.f13664a).commit();
        }
        return null;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        int i = 0;
        switch (this.f7831a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                LottieAnimationView lottieAnimationView = (LottieAnimationView) this.f7832b;
                String str = (String) this.f7833c;
                if (!lottieAnimationView.G) {
                    return n.b(lottieAnimationView.getContext(), str, null);
                }
                Context context = lottieAnimationView.getContext();
                HashMap map = n.f7882a;
                return n.b(context, str, "asset_" + str);
            case 1:
                return a();
            case 2:
                v1.i iVar = (v1.i) this.f7832b;
                byte[] bArr = (byte[]) this.f7833c;
                return cf.l.m(bArr, bArr.length, iVar.f13142c);
            case 3:
                v1.i iVar2 = (v1.i) this.f7832b;
                Uri uri = (Uri) this.f7833c;
                v1.h hVarG = iVar2.f13141b.g();
                int i10 = iVar2.f13142c;
                try {
                    v1.m mVar = new v1.m(uri, 0L, 1, null, Collections.EMPTY_MAP, 0L, -1L, null, 0);
                    v1.n nVar = (v1.n) hVarG;
                    nVar.h(mVar);
                    byte[] bArrCopyOf = new byte[1024];
                    int i11 = 0;
                    while (i != -1) {
                        if (i11 == bArrCopyOf.length) {
                            bArrCopyOf = Arrays.copyOf(bArrCopyOf, bArrCopyOf.length * 2);
                        }
                        i = nVar.read(bArrCopyOf, i11, bArrCopyOf.length - i11);
                        if (i != -1) {
                            i11 += i;
                        }
                    }
                    byte[] bArrCopyOf2 = Arrays.copyOf(bArrCopyOf, i11);
                    Bitmap bitmapM = cf.l.m(bArrCopyOf2, bArrCopyOf2.length, i10);
                    nVar.close();
                    return bitmapM;
                } catch (Throwable th) {
                    ((v1.n) hVarG).close();
                    throw th;
                }
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                return b();
            default:
                yb.c cVar = (yb.c) this.f7832b;
                yb.e eVar = (yb.e) this.f7833c;
                yb.n nVar2 = cVar.f14583b;
                synchronized (nVar2) {
                    FileOutputStream fileOutputStreamOpenFileOutput = nVar2.f14638a.openFileOutput(nVar2.f14639b, 0);
                    try {
                        fileOutputStreamOpenFileOutput.write(eVar.f14591a.toString().getBytes("UTF-8"));
                    } finally {
                        fileOutputStreamOpenFileOutput.close();
                    }
                }
                return null;
        }
    }
}
