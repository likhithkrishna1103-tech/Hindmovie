package o2;

import java.util.Arrays;
import java.util.Random;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Random f9108a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f9109b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int[] f9110c;

    public f1() {
        this(new Random());
    }

    public final f1 a(int i, int i10) {
        int[] iArr;
        Random random;
        int[] iArr2 = new int[i10];
        int[] iArr3 = new int[i10];
        int i11 = 0;
        while (true) {
            iArr = this.f9109b;
            random = this.f9108a;
            if (i11 >= i10) {
                break;
            }
            iArr2[i11] = random.nextInt(iArr.length + 1);
            int i12 = i11 + 1;
            int iNextInt = random.nextInt(i12);
            iArr3[i11] = iArr3[iNextInt];
            iArr3[iNextInt] = i11 + i;
            i11 = i12;
        }
        Arrays.sort(iArr2);
        int[] iArr4 = new int[iArr.length + i10];
        int i13 = 0;
        int i14 = 0;
        for (int i15 = 0; i15 < iArr.length + i10; i15++) {
            if (i13 >= i10 || i14 != iArr2[i13]) {
                int i16 = i14 + 1;
                int i17 = iArr[i14];
                iArr4[i15] = i17;
                if (i17 >= i) {
                    iArr4[i15] = i17 + i10;
                }
                i14 = i16;
            } else {
                iArr4[i15] = iArr3[i13];
                i13++;
            }
        }
        return new f1(iArr4, new Random(random.nextLong()));
    }

    public f1(int[] iArr, Random random) {
        this.f9109b = iArr;
        this.f9108a = random;
        this.f9110c = new int[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            this.f9110c[iArr[i]] = i;
        }
    }

    public f1(Random random) {
        this(new int[0], random);
    }
}
