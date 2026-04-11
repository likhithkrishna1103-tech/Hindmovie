package b2;

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
import qb.t1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class j implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1692a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1693b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f1694c;

    public /* synthetic */ j(int i, Object obj, Object obj2) {
        this.f1692a = i;
        this.f1693b = obj;
        this.f1694c = obj2;
    }

    private final Object a() {
        String str;
        ServiceInfo serviceInfo;
        String str2;
        int i;
        ComponentName componentNameStartService;
        Context context = (Context) this.f1693b;
        Intent intent = (Intent) this.f1694c;
        nc.p pVarP = nc.p.p();
        pVarP.getClass();
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Starting service");
        }
        ((ArrayDeque) pVarP.f9072d).offer(intent);
        Intent intent2 = new Intent("com.google.firebase.MESSAGING_EVENT");
        intent2.setPackage(context.getPackageName());
        synchronized (pVarP) {
            try {
                str = (String) pVarP.f9069a;
                if (str == null) {
                    ResolveInfo resolveInfoResolveService = context.getPackageManager().resolveService(intent2, 0);
                    if (resolveInfoResolveService == null || (serviceInfo = resolveInfoResolveService.serviceInfo) == null) {
                        Log.e("FirebaseMessaging", "Failed to resolve target intent service, skipping classname enforcement");
                    } else {
                        if (context.getPackageName().equals(serviceInfo.packageName) && (str2 = serviceInfo.name) != null) {
                            if (str2.startsWith(".")) {
                                pVarP.f9069a = context.getPackageName() + serviceInfo.name;
                            } else {
                                pVarP.f9069a = serviceInfo.name;
                            }
                            str = (String) pVarP.f9069a;
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
            if (pVarP.r(context)) {
                componentNameStartService = nc.x.d(context, intent2);
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
        } catch (IllegalStateException e9) {
            Log.e("FirebaseMessaging", "Failed to start service while in background: " + e9);
            i = 402;
        } catch (SecurityException e10) {
            Log.e("FirebaseMessaging", "Error while delivering the message to the serviceIntent", e10);
            i = 401;
        }
        return Integer.valueOf(i);
    }

    private final Object b() {
        qc.b bVar = (qc.b) this.f1693b;
        a3.t tVar = (a3.t) this.f1694c;
        rc.l lVar = bVar.i;
        synchronized (lVar.f10984b) {
            SharedPreferences.Editor editorEdit = lVar.f10983a.edit();
            tVar.getClass();
            editorEdit.putLong("fetch_timeout_in_seconds", 60L).putLong("minimum_fetch_interval_in_seconds", tVar.f227a).commit();
        }
        return null;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        int i = 0;
        switch (this.f1692a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                k kVar = (k) this.f1693b;
                byte[] bArr = (byte[]) this.f1694c;
                return t1.e(bArr, bArr.length, kVar.f1699c);
            case 1:
                k kVar2 = (k) this.f1693b;
                Uri uri = (Uri) this.f1694c;
                h hVarH = kVar2.f1698b.h();
                int i10 = kVar2.f1699c;
                try {
                    o oVar = new o(uri, 0L, 1, null, Collections.EMPTY_MAP, 0L, -1L, null, 0);
                    p pVar = (p) hVarH;
                    pVar.B(oVar);
                    byte[] bArrCopyOf = new byte[1024];
                    int i11 = 0;
                    while (i != -1) {
                        if (i11 == bArrCopyOf.length) {
                            bArrCopyOf = Arrays.copyOf(bArrCopyOf, bArrCopyOf.length * 2);
                        }
                        i = pVar.read(bArrCopyOf, i11, bArrCopyOf.length - i11);
                        if (i != -1) {
                            i11 += i;
                        }
                    }
                    byte[] bArrCopyOf2 = Arrays.copyOf(bArrCopyOf, i11);
                    Bitmap bitmapE = t1.e(bArrCopyOf2, bArrCopyOf2.length, i10);
                    pVar.close();
                    return bitmapE;
                } catch (Throwable th) {
                    ((p) hVarH).close();
                    throw th;
                }
            case 2:
                LottieAnimationView lottieAnimationView = (LottieAnimationView) this.f1693b;
                String str = (String) this.f1694c;
                if (!lottieAnimationView.H) {
                    return g6.n.b(lottieAnimationView.getContext(), str, null);
                }
                Context context = lottieAnimationView.getContext();
                HashMap map = g6.n.f5113a;
                return g6.n.b(context, str, "asset_" + str);
            case 3:
                return a();
            case g1.h.LONG_FIELD_NUMBER /* 4 */:
                return b();
            default:
                rc.c cVar = (rc.c) this.f1693b;
                rc.e eVar = (rc.e) this.f1694c;
                rc.m mVar = cVar.f10932b;
                synchronized (mVar) {
                    FileOutputStream fileOutputStreamOpenFileOutput = mVar.f10988a.openFileOutput(mVar.f10989b, 0);
                    try {
                        fileOutputStreamOpenFileOutput.write(eVar.f10940a.toString().getBytes("UTF-8"));
                    } finally {
                        fileOutputStreamOpenFileOutput.close();
                    }
                }
                return null;
        }
    }
}
