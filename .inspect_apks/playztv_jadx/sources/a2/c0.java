package a2;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c0 implements s1.m, z9.f, s1.h {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f176u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f177v;

    public /* synthetic */ c0(int i, int i10) {
        this.f176u = i10;
        this.f177v = i;
    }

    @Override // s1.m
    public void a(Object obj) {
        switch (this.f176u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ((p1.u0) obj).d(this.f177v);
                break;
            case 1:
                ((p1.u0) obj).e(this.f177v);
                break;
            default:
                b2.n nVar = (b2.n) obj;
                nVar.getClass();
                int i = this.f177v;
                if (i == 1) {
                    nVar.f1782v = true;
                }
                nVar.f1772l = i;
                break;
        }
    }

    @Override // s1.h
    public void accept(Object obj) {
        switch (this.f176u) {
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                ((g4.j1) obj).K(this.f177v);
                break;
            case b1.j.STRING_FIELD_NUMBER /* 5 */:
                ((g4.j1) obj).l0(this.f177v);
                break;
            case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                ((g4.j1) obj).i0(this.f177v);
                break;
            default:
                ((g4.j1) obj).I0(this.f177v);
                break;
        }
    }

    @Override // z9.f
    public Object apply(Object obj) {
        return Integer.valueOf(this.f177v);
    }

    public /* synthetic */ c0(b2.a aVar, int i, p1.v0 v0Var, p1.v0 v0Var2) {
        this.f176u = 3;
        this.f177v = i;
    }
}
