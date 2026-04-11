package a2;

import android.os.Looper;
import android.view.View;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.gms.internal.measurement.k4;
import com.google.android.material.sidesheet.SideSheetBehavior;
import com.playz.tv.activities.PlayerActivity;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class p0 implements Runnable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f377u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f378v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Object f379w;

    public /* synthetic */ p0(int i, int i10, Object obj) {
        this.f377u = i10;
        this.f379w = obj;
        this.f378v = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.f377u;
        int i10 = this.f378v;
        Object obj = this.f379w;
        switch (i) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                x0 x0Var = (x0) obj;
                b2.h hVar = x0Var.R;
                int i11 = ((g) x0Var.f498u[i10].f171e).f232v;
                hVar.W(hVar.V(), 1033, new s(17));
                break;
            case 1:
                c2.j jVar = (c2.j) ((k4) obj).f3071v;
                int i12 = s1.b0.f11647a;
                n.p pVar = ((l0) jVar).f312u.Z;
                c0 c0Var = new c0(i10, 2);
                pVar.getClass();
                s1.d.g(Looper.myLooper() == ((s1.y) pVar.f8477c).f11718a.getLooper());
                pVar.f8475a++;
                pVar.v(new o2.i0(pVar, 7, c0Var));
                pVar.B(Integer.valueOf(i10));
                break;
            case 2:
                ((h0.b) obj).h(i10);
                break;
            case 3:
                PlayerActivity playerActivity = (PlayerActivity) obj;
                ic.n nVar = (ic.n) playerActivity.Y.H(i10);
                ic.p pVar2 = playerActivity.Z;
                if (nVar == null) {
                    pVar2.getClass();
                    break;
                } else if (pVar2.f6539g != i10) {
                    ic.n nVar2 = pVar2.f6540h;
                    if (nVar2 != null) {
                        nVar2.f6536u.setChecked(false);
                    }
                    nVar.f6536u.setChecked(true);
                    pVar2.f6539g = i10;
                    pVar2.f6540h = nVar;
                    break;
                }
                break;
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                ((q1.a) obj).f10527b.onAudioFocusChange(i10);
                break;
            default:
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) obj;
                View view = (View) sideSheetBehavior.J.get();
                if (view != null) {
                    sideSheetBehavior.z(view, i10, false);
                }
                break;
        }
    }

    public /* synthetic */ p0(x0 x0Var, int i, boolean z2) {
        this.f377u = 0;
        this.f379w = x0Var;
        this.f378v = i;
    }
}
