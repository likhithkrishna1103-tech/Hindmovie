package c2;

import a2.l0;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.gms.internal.measurement.k4;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class h implements Runnable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f2329u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ k4 f2330v;

    public /* synthetic */ h(k4 k4Var, int i, long j5, long j8) {
        this.f2329u = 8;
        this.f2330v = k4Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.f2329u;
        int i10 = 24;
        k4 k4Var = this.f2330v;
        switch (i) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                j jVar = (j) k4Var.f3071v;
                int i11 = s1.b0.f11647a;
                b2.h hVar = ((l0) jVar).f312u.N;
                hVar.W(hVar.V(), 1029, new a2.s(i10));
                break;
            case 1:
                j jVar2 = (j) k4Var.f3071v;
                int i12 = s1.b0.f11647a;
                b2.h hVar2 = ((l0) jVar2).f312u.N;
                hVar2.W(hVar2.V(), 1031, new b2.d(26));
                break;
            case 2:
                j jVar3 = (j) k4Var.f3071v;
                int i13 = s1.b0.f11647a;
                b2.h hVar3 = ((l0) jVar3).f312u.N;
                hVar3.W(hVar3.V(), 1008, new a2.s(11));
                break;
            case 3:
                j jVar4 = (j) k4Var.f3071v;
                int i14 = s1.b0.f11647a;
                b2.h hVar4 = ((l0) jVar4).f312u.N;
                hVar4.W(hVar4.V(), 1012, new b2.d(27));
                break;
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                j jVar5 = (j) k4Var.f3071v;
                int i15 = s1.b0.f11647a;
                b2.h hVar5 = ((l0) jVar5).f312u.N;
                hVar5.W(hVar5.V(), 1007, new b2.d(0));
                break;
            case b1.j.STRING_FIELD_NUMBER /* 5 */:
                j jVar6 = (j) k4Var.f3071v;
                int i16 = s1.b0.f11647a;
                b2.h hVar6 = ((l0) jVar6).f312u.N;
                hVar6.W(hVar6.V(), 1014, new b2.d(17));
                break;
            case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                j jVar7 = (j) k4Var.f3071v;
                int i17 = s1.b0.f11647a;
                b2.h hVar7 = ((l0) jVar7).f312u.N;
                hVar7.W(hVar7.V(), 1009, new b2.d(13));
                break;
            case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                j jVar8 = (j) k4Var.f3071v;
                int i18 = s1.b0.f11647a;
                b2.h hVar8 = ((l0) jVar8).f312u.N;
                hVar8.W(hVar8.V(), 1010, new b2.d(2));
                break;
            case 8:
                j jVar9 = (j) k4Var.f3071v;
                int i19 = s1.b0.f11647a;
                b2.h hVar9 = ((l0) jVar9).f312u.N;
                hVar9.W(hVar9.V(), 1011, new b2.d(18));
                break;
            default:
                j jVar10 = (j) k4Var.f3071v;
                int i20 = s1.b0.f11647a;
                b2.h hVar10 = ((l0) jVar10).f312u.N;
                hVar10.W(hVar10.V(), 1032, new b2.d(24));
                break;
        }
    }

    public /* synthetic */ h(k4 k4Var, long j5) {
        this.f2329u = 7;
        this.f2330v = k4Var;
    }

    public /* synthetic */ h(k4 k4Var, Object obj, int i) {
        this.f2329u = i;
        this.f2330v = k4Var;
    }

    public /* synthetic */ h(k4 k4Var, String str, long j5, long j8) {
        this.f2329u = 2;
        this.f2330v = k4Var;
    }

    public /* synthetic */ h(k4 k4Var, p1.q qVar, a2.i iVar) {
        this.f2329u = 6;
        this.f2330v = k4Var;
    }
}
