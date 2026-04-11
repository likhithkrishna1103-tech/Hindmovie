package yd;

import java.io.Serializable;
import sd.d;
import sd.i;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends d implements Serializable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Enum[] f15052v;

    public a(Enum[] enumArr) {
        this.f15052v = enumArr;
    }

    @Override // sd.a
    public final int a() {
        return this.f15052v.length;
    }

    @Override // sd.a, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        if (!(obj instanceof Enum)) {
            return false;
        }
        Enum r42 = (Enum) obj;
        return ((Enum) i.u(r42.ordinal(), this.f15052v)) == r42;
    }

    @Override // java.util.List
    public final Object get(int i) {
        Enum[] enumArr = this.f15052v;
        int length = enumArr.length;
        if (i < 0 || i >= length) {
            throw new IndexOutOfBoundsException(q4.a.m(i, length, "index: ", ", size: "));
        }
        return enumArr[i];
    }

    @Override // sd.d, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Enum)) {
            return -1;
        }
        Enum r42 = (Enum) obj;
        int iOrdinal = r42.ordinal();
        if (((Enum) i.u(iOrdinal, this.f15052v)) == r42) {
            return iOrdinal;
        }
        return -1;
    }

    @Override // sd.d, java.util.List
    public final int lastIndexOf(Object obj) {
        if (!(obj instanceof Enum)) {
            return -1;
        }
        Enum r42 = (Enum) obj;
        int iOrdinal = r42.ordinal();
        if (((Enum) i.u(iOrdinal, this.f15052v)) == r42) {
            return iOrdinal;
        }
        return -1;
    }
}
