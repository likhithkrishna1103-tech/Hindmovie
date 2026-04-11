package a0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a extends c {
    public int B;
    public int C;
    public x.a D;

    public boolean getAllowsGoneWidget() {
        return this.D.f14096t0;
    }

    public int getMargin() {
        return this.D.f14097u0;
    }

    public int getType() {
        return this.B;
    }

    @Override // a0.c
    public final void h(x.e eVar, boolean z2) {
        int i = this.B;
        this.C = i;
        if (z2) {
            if (i == 5) {
                this.C = 1;
            } else if (i == 6) {
                this.C = 0;
            }
        } else if (i == 5) {
            this.C = 0;
        } else if (i == 6) {
            this.C = 1;
        }
        if (eVar instanceof x.a) {
            ((x.a) eVar).f14095s0 = this.C;
        }
    }

    public void setAllowsGoneWidget(boolean z2) {
        this.D.f14096t0 = z2;
    }

    public void setDpMargin(int i) {
        this.D.f14097u0 = (int) ((i * getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void setMargin(int i) {
        this.D.f14097u0 = i;
    }

    public void setType(int i) {
        this.B = i;
    }
}
