package w2;

import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class t {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final g4.d f13895g = new g4.d(19);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final g4.d f13896h = new g4.d(20);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f13900d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f13901e;
    public int f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s[] f13898b = new s[5];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f13897a = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f13899c = -1;

    public final void a(int i, float f) {
        s sVar;
        int i10 = this.f13899c;
        ArrayList arrayList = this.f13897a;
        if (i10 != 1) {
            Collections.sort(arrayList, f13895g);
            this.f13899c = 1;
        }
        int i11 = this.f;
        s[] sVarArr = this.f13898b;
        if (i11 > 0) {
            int i12 = i11 - 1;
            this.f = i12;
            sVar = sVarArr[i12];
        } else {
            sVar = new s();
        }
        int i13 = this.f13900d;
        this.f13900d = i13 + 1;
        sVar.f13892a = i13;
        sVar.f13893b = i;
        sVar.f13894c = f;
        arrayList.add(sVar);
        this.f13901e += i;
        while (true) {
            int i14 = this.f13901e;
            if (i14 <= 2000) {
                return;
            }
            int i15 = i14 - 2000;
            s sVar2 = (s) arrayList.get(0);
            int i16 = sVar2.f13893b;
            if (i16 <= i15) {
                this.f13901e -= i16;
                arrayList.remove(0);
                int i17 = this.f;
                if (i17 < 5) {
                    this.f = i17 + 1;
                    sVarArr[i17] = sVar2;
                }
            } else {
                sVar2.f13893b = i16 - i15;
                this.f13901e -= i15;
            }
        }
    }

    public final float b() {
        int i = this.f13899c;
        ArrayList arrayList = this.f13897a;
        if (i != 0) {
            Collections.sort(arrayList, f13896h);
            this.f13899c = 0;
        }
        float f = 0.5f * this.f13901e;
        int i10 = 0;
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            s sVar = (s) arrayList.get(i11);
            i10 += sVar.f13893b;
            if (i10 >= f) {
                return sVar.f13894c;
            }
        }
        if (arrayList.isEmpty()) {
            return Float.NaN;
        }
        return ((s) arrayList.get(arrayList.size() - 1)).f13894c;
    }
}
