package k8;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f7082u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ String f7083v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ long f7084w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ q f7085x;

    public /* synthetic */ b(q qVar, String str, long j5, int i) {
        this.f7082u = i;
        this.f7083v = str;
        this.f7084w = j5;
        this.f7085x = qVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7082u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                q qVar = this.f7085x;
                qVar.p1();
                String str = this.f7083v;
                t7.v.d(str);
                s.e eVar = qVar.f7377x;
                boolean zIsEmpty = eVar.isEmpty();
                long j5 = this.f7084w;
                if (zIsEmpty) {
                    qVar.f7378y = j5;
                }
                Integer num = (Integer) eVar.get(str);
                if (num != null) {
                    eVar.put(str, Integer.valueOf(num.intValue() + 1));
                } else if (eVar.f11635w < 100) {
                    eVar.put(str, 1);
                    qVar.f7376w.put(str, Long.valueOf(j5));
                } else {
                    qVar.g().D.d("Too many ads visible");
                }
                break;
            default:
                q qVar2 = this.f7085x;
                qVar2.p1();
                s.e eVar2 = qVar2.f7376w;
                String str2 = this.f7083v;
                t7.v.d(str2);
                s.e eVar3 = qVar2.f7377x;
                Integer num2 = (Integer) eVar3.get(str2);
                if (num2 == null) {
                    qVar2.g().A.c(str2, "Call to endAdUnitExposure for unknown ad unit id");
                } else {
                    w2 w2VarX1 = qVar2.r1().x1(false);
                    int iIntValue = num2.intValue() - 1;
                    if (iIntValue != 0) {
                        eVar3.put(str2, Integer.valueOf(iIntValue));
                    } else {
                        eVar3.remove(str2);
                        Long l10 = (Long) eVar2.get(str2);
                        long j8 = this.f7084w;
                        if (l10 == null) {
                            qVar2.g().A.d("First ad unit exposure time was never set");
                        } else {
                            long jLongValue = j8 - l10.longValue();
                            eVar2.remove(str2);
                            qVar2.w1(str2, jLongValue, w2VarX1);
                        }
                        if (eVar3.isEmpty()) {
                            long j10 = qVar2.f7378y;
                            if (j10 != 0) {
                                qVar2.u1(j8 - j10, w2VarX1);
                                qVar2.f7378y = 0L;
                            } else {
                                qVar2.g().A.d("First ad exposure time was never set");
                            }
                        }
                    }
                }
                break;
        }
    }
}
