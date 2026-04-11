package k8;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class l2 implements Runnable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f7305u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ Object f7306v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Object f7307w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ Object f7308x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ Object f7309y;

    public /* synthetic */ l2(Object obj, Object obj2, Object obj3, Object obj4, int i) {
        this.f7305u = i;
        this.f7307w = obj2;
        this.f7308x = obj3;
        this.f7306v = obj4;
        this.f7309y = obj;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00c8 -> B:67:0x00cf). Please report as a decompilation issue!!! */
    @Override // java.lang.Runnable
    public final void run() {
        z2 z2Var;
        h0 h0Var;
        switch (this.f7305u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                z2 z2VarP = ((AppMeasurementDynamiteService) this.f7309y).f3299d.p();
                com.google.android.gms.internal.measurement.w0 w0Var = (com.google.android.gms.internal.measurement.w0) this.f7307w;
                v vVar = (v) this.f7308x;
                String str = (String) this.f7306v;
                z2VarP.p1();
                z2VarP.t1();
                if (q7.f.f11040b.b(((k1) z2VarP.o1().f2454v).f7282u, 12451000) == 0) {
                    z2VarP.w1(new l2(z2VarP, vVar, str, w0Var));
                    return;
                } else {
                    z2VarP.g().D.d("Not bundling data. Service unavailable or out of date");
                    z2VarP.o1().O1(w0Var, new byte[0]);
                    return;
                }
            case 1:
                z2 z2VarP2 = ((k1) ((g2) this.f7309y).f2454v).p();
                AtomicReference atomicReference = (AtomicReference) this.f7307w;
                String str2 = (String) this.f7306v;
                String str3 = (String) this.f7308x;
                z2VarP2.p1();
                z2VarP2.t1();
                z2VarP2.w1(new e3(z2VarP2, atomicReference, str2, str3, z2VarP2.I1(false)));
                return;
            case 2:
                z2 z2VarP3 = ((AppMeasurementDynamiteService) this.f7309y).f3299d.p();
                com.google.android.gms.internal.measurement.w0 w0Var2 = (com.google.android.gms.internal.measurement.w0) this.f7307w;
                String str4 = (String) this.f7306v;
                String str5 = (String) this.f7308x;
                z2VarP3.p1();
                z2VarP3.t1();
                z2VarP3.w1(new e3(z2VarP3, str4, str5, z2VarP3.I1(false), w0Var2));
                return;
            case 3:
                synchronized (((AtomicReference) this.f7307w)) {
                    try {
                        try {
                            z2Var = (z2) this.f7309y;
                            h0Var = z2Var.f7573y;
                        } catch (RemoteException e10) {
                            ((z2) this.f7309y).g().A.c(e10, "Failed to get trigger URIs; remote exception");
                        }
                        if (h0Var == null) {
                            z2Var.g().A.d("Failed to get trigger URIs; not connected to service");
                            return;
                        }
                        ((AtomicReference) this.f7307w).set(h0Var.g((Bundle) this.f7306v, (a4) this.f7308x));
                        ((z2) this.f7309y).H1();
                        ((AtomicReference) this.f7307w).notify();
                        return;
                    } finally {
                        ((AtomicReference) this.f7307w).notify();
                    }
                }
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                com.google.android.gms.internal.measurement.w0 w0Var3 = (com.google.android.gms.internal.measurement.w0) this.f7307w;
                z2 z2Var2 = (z2) this.f7309y;
                byte[] bArrW = null;
                try {
                    h0 h0Var2 = z2Var2.f7573y;
                    if (h0Var2 == null) {
                        z2Var2.g().A.d("Discarding data. Failed to send event to service to bundle");
                    } else {
                        bArrW = h0Var2.w((v) this.f7308x, (String) this.f7306v);
                        z2Var2.H1();
                        z2Var2.o1().O1(w0Var3, bArrW);
                    }
                } catch (RemoteException e11) {
                    z2Var2.g().A.c(e11, "Failed to send event to the service to bundle");
                } finally {
                    z2Var2.o1().O1(w0Var3, bArrW);
                }
                return;
            case b1.j.STRING_FIELD_NUMBER /* 5 */:
                x3 x3Var = (x3) ((rc.b) this.f7309y).f11562v;
                h4 h4VarC0 = x3Var.c0();
                String str6 = (String) this.f7307w;
                Bundle bundle = (Bundle) this.f7308x;
                x3Var.y0().getClass();
                v vVarE1 = h4VarC0.E1(str6, bundle, "auto", System.currentTimeMillis(), false);
                t7.v.h(vVarE1);
                x3Var.u(vVarE1, (String) this.f7306v);
                return;
            case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                m.e eVar = (m.e) ((rc.b) this.f7309y).f11562v;
                m.m mVar = (m.m) this.f7308x;
                m.d dVar = (m.d) this.f7307w;
                if (dVar != null) {
                    eVar.T = true;
                    dVar.f8183b.c(false);
                    eVar.T = false;
                }
                if (mVar.isEnabled() && mVar.hasSubMenu()) {
                    ((m.k) this.f7306v).q(mVar, null, 4);
                    return;
                }
                return;
            default:
                q0.x0.i((View) this.f7307w, (q0.b1) this.f7308x, (pb.c) this.f7306v);
                ((ValueAnimator) this.f7309y).start();
                return;
        }
    }

    public /* synthetic */ l2(Object obj, Object obj2, String str, String str2, int i) {
        this.f7305u = i;
        this.f7307w = obj2;
        this.f7306v = str;
        this.f7308x = str2;
        this.f7309y = obj;
    }

    public l2(z2 z2Var, v vVar, String str, com.google.android.gms.internal.measurement.w0 w0Var) {
        this.f7305u = 4;
        this.f7308x = vVar;
        this.f7306v = str;
        this.f7307w = w0Var;
        this.f7309y = z2Var;
    }

    public l2(rc.b bVar, String str, String str2, Bundle bundle) {
        this.f7305u = 5;
        this.f7306v = str;
        this.f7307w = str2;
        this.f7308x = bundle;
        this.f7309y = bVar;
    }

    public l2(View view, q0.b1 b1Var, pb.c cVar, ValueAnimator valueAnimator) {
        this.f7305u = 7;
        this.f7307w = view;
        this.f7308x = b1Var;
        this.f7306v = cVar;
        this.f7309y = valueAnimator;
    }
}
