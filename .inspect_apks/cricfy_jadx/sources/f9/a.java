package f9;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f3991v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ String f3992w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ long f3993x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ y f3994y;

    public /* synthetic */ a(y yVar, String str, long j4, int i) {
        this.f3991v = i;
        this.f3992w = str;
        this.f3993x = j4;
        this.f3994y = yVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3991v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                y yVar = this.f3994y;
                yVar.m1();
                String str = this.f3992w;
                o8.u.d(str);
                v.e eVar = yVar.f4492y;
                boolean zIsEmpty = eVar.isEmpty();
                long j4 = this.f3993x;
                if (zIsEmpty) {
                    yVar.f4493z = j4;
                }
                Integer num = (Integer) eVar.get(str);
                if (num != null) {
                    eVar.put(str, Integer.valueOf(num.intValue() + 1));
                } else if (eVar.f12542x < 100) {
                    eVar.put(str, 1);
                    yVar.f4491x.put(str, Long.valueOf(j4));
                } else {
                    w0 w0Var = ((r1) yVar.f307w).A;
                    r1.g(w0Var);
                    w0Var.E.a("Too many ads visible");
                }
                break;
            default:
                y yVar2 = this.f3994y;
                r1 r1Var = (r1) yVar2.f307w;
                yVar2.m1();
                String str2 = this.f3992w;
                o8.u.d(str2);
                v.e eVar2 = yVar2.f4492y;
                Integer num2 = (Integer) eVar2.get(str2);
                if (num2 == null) {
                    w0 w0Var2 = r1Var.A;
                    r1.g(w0Var2);
                    w0Var2.B.b(str2, "Call to endAdUnitExposure for unknown ad unit id");
                } else {
                    j3 j3Var = r1Var.G;
                    w0 w0Var3 = r1Var.A;
                    r1.f(j3Var);
                    f3 f3VarS1 = j3Var.s1(false);
                    int iIntValue = num2.intValue() - 1;
                    if (iIntValue != 0) {
                        eVar2.put(str2, Integer.valueOf(iIntValue));
                    } else {
                        eVar2.remove(str2);
                        v.e eVar3 = yVar2.f4491x;
                        Long l10 = (Long) eVar3.get(str2);
                        long j7 = this.f3993x;
                        if (l10 == null) {
                            r1.g(w0Var3);
                            w0Var3.B.a("First ad unit exposure time was never set");
                        } else {
                            long jLongValue = j7 - l10.longValue();
                            eVar3.remove(str2);
                            yVar2.r1(str2, jLongValue, f3VarS1);
                        }
                        if (eVar2.isEmpty()) {
                            long j10 = yVar2.f4493z;
                            if (j10 != 0) {
                                yVar2.q1(j7 - j10, f3VarS1);
                                yVar2.f4493z = 0L;
                            } else {
                                r1.g(w0Var3);
                                w0Var3.B.a("First ad exposure time was never set");
                            }
                        }
                    }
                }
                break;
        }
    }
}
