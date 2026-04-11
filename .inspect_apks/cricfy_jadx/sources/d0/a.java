package d0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends c {
    public int C;
    public int D;
    public a0.a E;

    public boolean getAllowsGoneWidget() {
        return this.E.f1t0;
    }

    public int getMargin() {
        return this.E.f2u0;
    }

    public int getType() {
        return this.C;
    }

    @Override // d0.c
    public final void h(a0.d dVar, boolean z10) {
        int i = this.C;
        this.D = i;
        if (z10) {
            if (i == 5) {
                this.D = 1;
            } else if (i == 6) {
                this.D = 0;
            }
        } else if (i == 5) {
            this.D = 0;
        } else if (i == 6) {
            this.D = 1;
        }
        if (dVar instanceof a0.a) {
            ((a0.a) dVar).f0s0 = this.D;
        }
    }

    public void setAllowsGoneWidget(boolean z10) {
        this.E.f1t0 = z10;
    }

    public void setDpMargin(int i) {
        this.E.f2u0 = (int) ((i * getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void setMargin(int i) {
        this.E.f2u0 = i;
    }

    public void setType(int i) {
        this.C = i;
    }
}
