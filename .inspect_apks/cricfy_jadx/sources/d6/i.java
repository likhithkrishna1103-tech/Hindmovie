package d6;

import a3.m;
import android.os.Looper;
import android.view.View;
import androidx.media3.decoder.DecoderInputBuffer;
import app.cricfy.tv.activities.PlayerActivity;
import com.google.android.material.sidesheet.SideSheetBehavior;
import g2.d0;
import g2.o0;
import g2.x;
import s5.l;
import s5.n;
import y1.a0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class i implements Runnable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f3417v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ int f3418w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ Object f3419x;

    public /* synthetic */ i(int i, int i10, Object obj) {
        this.f3417v = i10;
        this.f3419x = obj;
        this.f3418w = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.f3417v;
        int i10 = this.f3418w;
        Object obj = this.f3419x;
        switch (i) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                k kVar = (k) obj;
                l lVar = (l) kVar.f3427g.H(i10);
                n nVar = kVar.f3428h;
                if (lVar == null) {
                    nVar.getClass();
                    break;
                } else if (nVar.f11513g != i10) {
                    l lVar2 = nVar.f11514h;
                    if (lVar2 != null) {
                        lVar2.f11510u.setChecked(false);
                    }
                    lVar.f11510u.setChecked(true);
                    nVar.f11513g = i10;
                    nVar.f11514h = lVar;
                    break;
                }
                break;
            case 1:
                o0 o0Var = (o0) obj;
                h2.f fVar = o0Var.S;
                int i11 = ((g2.e) o0Var.f4841v[i10].f4884e).f4658w;
                fVar.W(fVar.V(), 1033, new m(25));
                break;
            case 2:
                i2.l lVar3 = (i2.l) ((i2.k) obj).f6086w;
                int i12 = a0.f14551a;
                ff.k kVar2 = ((d0) lVar3).f4651v.f4689a0;
                x xVar = new x(i10, 2);
                kVar2.getClass();
                y1.d.g(Looper.myLooper() == ((y1.x) kVar2.f4588c).f14618a.getLooper());
                kVar2.f4586a++;
                kVar2.G(new nc.i(14, kVar2, xVar));
                kVar2.M(Integer.valueOf(i10));
                break;
            case 3:
                ((k0.b) obj).h(i10);
                break;
            case g1.h.LONG_FIELD_NUMBER /* 4 */:
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) obj;
                View view = (View) sideSheetBehavior.K.get();
                if (view != null) {
                    sideSheetBehavior.z(view, i10, false);
                }
                break;
            case g1.h.STRING_FIELD_NUMBER /* 5 */:
                PlayerActivity playerActivity = (PlayerActivity) obj;
                l lVar4 = (l) playerActivity.Z.H(i10);
                n nVar2 = playerActivity.f1516a0;
                if (lVar4 == null) {
                    nVar2.getClass();
                    break;
                } else if (nVar2.f11513g != i10) {
                    l lVar5 = nVar2.f11514h;
                    if (lVar5 != null) {
                        lVar5.f11510u.setChecked(false);
                    }
                    lVar4.f11510u.setChecked(true);
                    nVar2.f11513g = i10;
                    nVar2.f11514h = lVar4;
                    break;
                }
                break;
            default:
                ((w1.b) obj).f13779b.onAudioFocusChange(i10);
                break;
        }
    }

    public /* synthetic */ i(o0 o0Var, int i, boolean z10) {
        this.f3417v = 1;
        this.f3419x = o0Var;
        this.f3418w = i;
    }
}
