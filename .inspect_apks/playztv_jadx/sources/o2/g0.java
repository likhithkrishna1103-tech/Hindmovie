package o2;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class g0 implements s1.h {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f9111u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ aa.l0 f9112v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ u f9113w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ z f9114x;

    public /* synthetic */ g0(aa.l0 l0Var, u uVar, z zVar, int i) {
        this.f9111u = i;
        this.f9112v = l0Var;
        this.f9113w = uVar;
        this.f9114x = zVar;
    }

    @Override // s1.h
    public final void accept(Object obj) {
        k0 k0Var = (k0) obj;
        switch (this.f9111u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                aa.l0 l0Var = this.f9112v;
                k0Var.I(l0Var.f705v, (d0) l0Var.f706w, this.f9113w, this.f9114x);
                break;
            default:
                aa.l0 l0Var2 = this.f9112v;
                k0Var.c(l0Var2.f705v, (d0) l0Var2.f706w, this.f9113w, this.f9114x);
                break;
        }
    }
}
