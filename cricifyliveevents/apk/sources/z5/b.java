package z5;

import android.content.Context;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import java.io.File;
import java.util.List;
import x5.u;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements cd.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l4.a f15203a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l4.a f15204b;

    public b(l4.a aVar, l4.a aVar2) {
        this.f15204b = aVar;
        this.f15203a = aVar2;
    }

    @Override // cd.e
    public final void a(dd.e eVar, cd.b bVar, Throwable th) {
        String message = th.getMessage();
        u uVar = (u) this.f15203a.f7697v;
        if (uVar.j() == null) {
            return;
        }
        Toast.makeText(uVar.j(), "Error: " + message, 0).show();
    }

    @Override // cd.e
    public final void b(dd.e eVar) {
        u uVar = (u) this.f15203a.f7697v;
        if (uVar.j() == null) {
            return;
        }
        Toast.makeText(uVar.j(), "Install", 0).show();
        l4.a aVar = uVar.f14387v0;
        Context contextJ = uVar.j();
        l4.a aVar2 = uVar.f14387v0;
        Context contextJ2 = uVar.j();
        String str = uVar.f14386u0;
        aVar2.getClass();
        File fileS = l4.a.s(contextJ2, str);
        aVar.getClass();
        l4.a.A(contextJ, fileS);
        uVar.f14389x0 = true;
        ((Button) uVar.f14384s0.f5927c).setText("Install");
        ((Button) uVar.f14384s0.f5927c).setVisibility(0);
        ((Button) uVar.f14384s0.f5930g).setVisibility(8);
        ((Button) uVar.f14384s0.f5931h).setVisibility(8);
    }

    @Override // cd.e
    public final void c(dd.e eVar, long j4, long j7) {
        long j10 = eVar.C;
        long j11 = eVar.D;
        int i = j11 < 1 ? -1 : j10 < 1 ? 0 : j10 >= j11 ? 100 : (int) ((j10 / j11) * ((double) 100));
        String strO = l4.a.o(this.f15204b, j10);
        u uVar = (u) this.f15203a.f7697v;
        if (uVar.j() == null) {
            return;
        }
        ((TextView) uVar.f14384s0.f5929e).setText(strO);
        ((TextView) uVar.f14384s0.f5928d).setText(i + "%");
        ((ProgressBar) uVar.f14384s0.f5926b).setProgress(i);
    }

    @Override // cd.e
    public final void d(dd.e eVar, List list, int i) {
        String strO = l4.a.o(this.f15204b, eVar.D);
        u uVar = (u) this.f15203a.f7697v;
        if (uVar.j() == null) {
            return;
        }
        ((TextView) uVar.f14384s0.f).setText(" / " + strO);
    }

    @Override // cd.e
    public final void e(dd.e eVar) {
    }

    @Override // cd.e
    public final void h(dd.e eVar) {
    }

    @Override // cd.e
    public final void f(dd.e eVar, boolean z10) {
    }

    @Override // cd.e
    public final void g(dd.e eVar, md.b bVar, int i) {
    }
}
