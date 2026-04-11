package f9;

import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class n2 implements Runnable {
    public final /* synthetic */ Object A;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f4285v = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Object f4286w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ Object f4287x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ boolean f4288y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ Object f4289z;

    public n2(AppMeasurementDynamiteService appMeasurementDynamiteService, com.google.android.gms.internal.measurement.l0 l0Var, String str, String str2, boolean z10) {
        this.f4289z = l0Var;
        this.f4286w = str;
        this.f4287x = str2;
        this.f4288y = z10;
        this.A = appMeasurementDynamiteService;
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x010b A[Catch: RuntimeException -> 0x00e5, TRY_ENTER, TryCatch #0 {RuntimeException -> 0x00e5, blocks: (B:53:0x010b, B:55:0x0116, B:58:0x0123, B:60:0x0129, B:62:0x0143, B:64:0x014c, B:67:0x0154, B:70:0x016d, B:72:0x017c, B:71:0x0174, B:73:0x018f, B:75:0x0195, B:77:0x019b, B:79:0x01a1, B:81:0x01a7, B:83:0x01af, B:85:0x01b7, B:87:0x01bd, B:88:0x01cf, B:26:0x0094, B:28:0x009a, B:30:0x00a4, B:32:0x00aa, B:34:0x00b0, B:36:0x00b6, B:38:0x00be, B:40:0x00c6, B:42:0x00ce, B:44:0x00d6, B:48:0x00ec, B:50:0x00fa), top: B:100:0x0094 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0154 A[Catch: RuntimeException -> 0x00e5, TryCatch #0 {RuntimeException -> 0x00e5, blocks: (B:53:0x010b, B:55:0x0116, B:58:0x0123, B:60:0x0129, B:62:0x0143, B:64:0x014c, B:67:0x0154, B:70:0x016d, B:72:0x017c, B:71:0x0174, B:73:0x018f, B:75:0x0195, B:77:0x019b, B:79:0x01a1, B:81:0x01a7, B:83:0x01af, B:85:0x01b7, B:87:0x01bd, B:88:0x01cf, B:26:0x0094, B:28:0x009a, B:30:0x00a4, B:32:0x00aa, B:34:0x00b0, B:36:0x00b6, B:38:0x00be, B:40:0x00c6, B:42:0x00ce, B:44:0x00d6, B:48:0x00ec, B:50:0x00fa), top: B:100:0x0094 }] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 608
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f9.n2.run():void");
    }

    public n2(t2 t2Var, boolean z10, Uri uri, String str, String str2) {
        this.f4288y = z10;
        this.f4289z = uri;
        this.f4286w = str;
        this.f4287x = str2;
        this.A = t2Var;
    }

    public n2(x2 x2Var, AtomicReference atomicReference, String str, String str2, boolean z10) {
        this.f4289z = atomicReference;
        this.f4286w = str;
        this.f4287x = str2;
        this.f4288y = z10;
        Objects.requireNonNull(x2Var);
        this.A = x2Var;
    }

    public n2(t3 t3Var, w4 w4Var, boolean z10, u uVar, Bundle bundle) {
        this.f4289z = w4Var;
        this.f4288y = z10;
        this.f4286w = uVar;
        this.f4287x = bundle;
        Objects.requireNonNull(t3Var);
        this.A = t3Var;
    }
}
