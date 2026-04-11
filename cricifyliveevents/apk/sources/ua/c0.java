package ua;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object[] f12309a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f12310b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f12311c;

    public c0(int i) {
        q.d(i, "initialCapacity");
        this.f12309a = new Object[i];
        this.f12310b = 0;
    }

    public static int f(int i, int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException("cannot store more than MAX_VALUE elements");
        }
        if (i10 <= i) {
            return i;
        }
        int iHighestOneBit = i + (i >> 1) + 1;
        if (iHighestOneBit < i10) {
            iHighestOneBit = Integer.highestOneBit(i10 - 1) << 1;
        }
        if (iHighestOneBit < 0) {
            return Integer.MAX_VALUE;
        }
        return iHighestOneBit;
    }

    public final void a(Object obj) {
        obj.getClass();
        e(1);
        Object[] objArr = this.f12309a;
        int i = this.f12310b;
        this.f12310b = i + 1;
        objArr[i] = obj;
    }

    public final void b(Object... objArr) {
        int length = objArr.length;
        q.b(length, objArr);
        e(length);
        System.arraycopy(objArr, 0, this.f12309a, this.f12310b, length);
        this.f12310b += length;
    }

    public abstract c0 c(Object obj);

    public final void d(Iterable iterable) {
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            e(collection.size());
            if (collection instanceof d0) {
                this.f12310b = ((d0) collection).b(this.f12310b, this.f12309a);
                return;
            }
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            c(it.next());
        }
    }

    public final void e(int i) {
        Object[] objArr = this.f12309a;
        int iF = f(objArr.length, this.f12310b + i);
        if (iF > objArr.length || this.f12311c) {
            this.f12309a = Arrays.copyOf(this.f12309a, iF);
            this.f12311c = false;
        }
    }
}
