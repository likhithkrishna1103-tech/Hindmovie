package aa;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class o0 extends e0 implements Set {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ int f718w = 0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public transient j0 f719v;

    public static int l(int i) {
        int iMax = Math.max(i, 2);
        if (iMax >= 751619276) {
            q1.c.g("collection too large", iMax < 1073741824);
            return 1073741824;
        }
        int iHighestOneBit = Integer.highestOneBit(iMax - 1) << 1;
        while (((double) iHighestOneBit) * 0.7d < iMax) {
            iHighestOneBit <<= 1;
        }
        return iHighestOneBit;
    }

    public static o0 n(int i, Object... objArr) {
        if (i == 0) {
            return i1.D;
        }
        if (i == 1) {
            Object obj = objArr[0];
            Objects.requireNonNull(obj);
            return new o1(obj);
        }
        int iL = l(i);
        Object[] objArr2 = new Object[iL];
        int i10 = iL - 1;
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < i; i13++) {
            Object obj2 = objArr[i13];
            if (obj2 == null) {
                throw new NullPointerException(e6.j.l("at index ", i13));
            }
            int iHashCode = obj2.hashCode();
            int iR = q.r(iHashCode);
            while (true) {
                int i14 = iR & i10;
                Object obj3 = objArr2[i14];
                if (obj3 == null) {
                    objArr[i12] = obj2;
                    objArr2[i14] = obj2;
                    i11 += iHashCode;
                    i12++;
                    break;
                }
                if (obj3.equals(obj2)) {
                    break;
                }
                iR++;
            }
        }
        Arrays.fill(objArr, i12, i, (Object) null);
        if (i12 == 1) {
            Object obj4 = objArr[0];
            Objects.requireNonNull(obj4);
            return new o1(obj4);
        }
        if (l(i12) < iL / 2) {
            return n(i12, objArr);
        }
        int length = objArr.length;
        if (i12 < (length >> 1) + (length >> 2)) {
            objArr = Arrays.copyOf(objArr, i12);
        }
        return new i1(i11, i10, i12, objArr, objArr2);
    }

    public static o0 r(Collection collection) {
        if ((collection instanceof o0) && !(collection instanceof SortedSet)) {
            o0 o0Var = (o0) collection;
            if (!o0Var.i()) {
                return o0Var;
            }
        }
        Object[] array = collection.toArray();
        return n(array.length, array);
    }

    public static o0 t(String str, String str2, String str3, String str4, String str5, String str6, Object... objArr) {
        q1.c.g("the total number of elements must fit in an int", objArr.length <= 2147483641);
        int length = objArr.length + 6;
        Object[] objArr2 = new Object[length];
        objArr2[0] = str;
        objArr2[1] = str2;
        objArr2[2] = str3;
        objArr2[3] = str4;
        objArr2[4] = str5;
        objArr2[5] = str6;
        System.arraycopy(objArr, 0, objArr2, 6, objArr.length);
        return n(length, objArr2);
    }

    @Override // aa.e0
    public j0 b() {
        j0 j0Var = this.f719v;
        if (j0Var != null) {
            return j0Var;
        }
        j0 j0VarS = s();
        this.f719v = j0VarS;
        return j0VarS;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof o0) && (this instanceof i1) && (((o0) obj) instanceof i1) && hashCode() != obj.hashCode()) {
            return false;
        }
        return q.h(this, obj);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return q.l(this);
    }

    public j0 s() {
        Object[] array = toArray(e0.f663u);
        h0 h0Var = j0.f690v;
        return j0.l(array.length, array);
    }
}
