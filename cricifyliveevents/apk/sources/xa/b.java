package xa;

import com.bumptech.glide.d;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends AbstractList implements RandomAccess, Serializable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int[] f14468v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f14469w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f14470x;

    public b(int i, int i10, int[] iArr) {
        this.f14468v = iArr;
        this.f14469w = i;
        this.f14470x = i10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        if (obj instanceof Integer) {
            return d.v(this.f14468v, ((Integer) obj).intValue(), this.f14469w, this.f14470x) != -1;
        }
        return false;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return super.equals(obj);
        }
        b bVar = (b) obj;
        int size = size();
        if (bVar.size() != size) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (this.f14468v[this.f14469w + i] != bVar.f14468v[bVar.f14469w + i]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        d.g(i, size());
        return Integer.valueOf(this.f14468v[this.f14469w + i]);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i10 = this.f14469w; i10 < this.f14470x; i10++) {
            i = (i * 31) + this.f14468v[i10];
        }
        return i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int iIntValue = ((Integer) obj).intValue();
        int i = this.f14470x;
        int[] iArr = this.f14468v;
        int i10 = this.f14469w;
        int iV = d.v(iArr, iIntValue, i10, i);
        if (iV >= 0) {
            return iV - i10;
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return false;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        int i;
        if (obj instanceof Integer) {
            int iIntValue = ((Integer) obj).intValue();
            int i10 = this.f14470x;
            while (true) {
                i10--;
                i = this.f14469w;
                if (i10 < i) {
                    i10 = -1;
                    break;
                }
                if (this.f14468v[i10] == iIntValue) {
                    break;
                }
            }
            if (i10 >= 0) {
                return i10 - i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        Integer num = (Integer) obj;
        d.g(i, size());
        int i10 = this.f14469w + i;
        int[] iArr = this.f14468v;
        int i11 = iArr[i10];
        num.getClass();
        iArr[i10] = num.intValue();
        return Integer.valueOf(i11);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f14470x - this.f14469w;
    }

    @Override // java.util.AbstractList, java.util.List
    public final List subList(int i, int i10) {
        d.j(i, i10, size());
        if (i == i10) {
            return Collections.EMPTY_LIST;
        }
        int i11 = this.f14469w;
        return new b(i + i11, i11 + i10, this.f14468v);
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        StringBuilder sb = new StringBuilder(size() * 5);
        sb.append('[');
        int[] iArr = this.f14468v;
        int i = this.f14469w;
        sb.append(iArr[i]);
        while (true) {
            i++;
            if (i >= this.f14470x) {
                sb.append(']');
                return sb.toString();
            }
            sb.append(", ");
            sb.append(iArr[i]);
        }
    }
}
