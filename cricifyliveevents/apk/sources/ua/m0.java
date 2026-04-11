package ua;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class m0 extends d0 implements Set {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final /* synthetic */ int f12358x = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public transient i0 f12359w;

    public static int i(int i) {
        int iMax = Math.max(i, 2);
        if (iMax >= 751619276) {
            com.bumptech.glide.d.f("collection too large", iMax < 1073741824);
            return 1073741824;
        }
        int iHighestOneBit = Integer.highestOneBit(iMax - 1) << 1;
        while (((double) iHighestOneBit) * 0.7d < iMax) {
            iHighestOneBit <<= 1;
        }
        return iHighestOneBit;
    }

    public static m0 j(int i, Object... objArr) {
        if (i == 0) {
            return f1.E;
        }
        if (i == 1) {
            Object obj = objArr[0];
            Objects.requireNonNull(obj);
            return new l1(obj);
        }
        int i10 = i(i);
        Object[] objArr2 = new Object[i10];
        int i11 = i10 - 1;
        int i12 = 0;
        int i13 = 0;
        for (int i14 = 0; i14 < i; i14++) {
            Object obj2 = objArr[i14];
            if (obj2 == null) {
                throw new NullPointerException(l0.e.g(i14, "at index "));
            }
            int iHashCode = obj2.hashCode();
            int iS = q.s(iHashCode);
            while (true) {
                int i15 = iS & i11;
                Object obj3 = objArr2[i15];
                if (obj3 == null) {
                    objArr[i13] = obj2;
                    objArr2[i15] = obj2;
                    i12 += iHashCode;
                    i13++;
                    break;
                }
                if (obj3.equals(obj2)) {
                    break;
                }
                iS++;
            }
        }
        Arrays.fill(objArr, i13, i, (Object) null);
        if (i13 == 1) {
            Object obj4 = objArr[0];
            Objects.requireNonNull(obj4);
            return new l1(obj4);
        }
        if (i(i13) < i10 / 2) {
            return j(i13, objArr);
        }
        int length = objArr.length;
        if (i13 < (length >> 1) + (length >> 2)) {
            objArr = Arrays.copyOf(objArr, i13);
        }
        return new f1(i12, i11, i13, objArr, objArr2);
    }

    public static m0 k(Collection collection) {
        if ((collection instanceof m0) && !(collection instanceof SortedSet)) {
            m0 m0Var = (m0) collection;
            if (!m0Var.g()) {
                return m0Var;
            }
        }
        Object[] array = collection.toArray();
        return j(array.length, array);
    }

    public static m0 m(String str, String str2, String str3, String str4, String str5, String str6, Object... objArr) {
        com.bumptech.glide.d.f("the total number of elements must fit in an int", objArr.length <= 2147483641);
        int length = objArr.length + 6;
        Object[] objArr2 = new Object[length];
        objArr2[0] = str;
        objArr2[1] = str2;
        objArr2[2] = str3;
        objArr2[3] = str4;
        objArr2[4] = str5;
        objArr2[5] = str6;
        System.arraycopy(objArr, 0, objArr2, 6, objArr.length);
        return j(length, objArr2);
    }

    @Override // ua.d0
    public i0 a() {
        i0 i0Var = this.f12359w;
        if (i0Var != null) {
            return i0Var;
        }
        i0 i0VarL = l();
        this.f12359w = i0VarL;
        return i0VarL;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof m0) && (this instanceof f1) && (((m0) obj) instanceof f1) && hashCode() != obj.hashCode()) {
            return false;
        }
        return q.i(this, obj);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return q.m(this);
    }

    public i0 l() {
        Object[] array = toArray(d0.f12318v);
        g0 g0Var = i0.f12341w;
        return i0.i(array.length, array);
    }
}
