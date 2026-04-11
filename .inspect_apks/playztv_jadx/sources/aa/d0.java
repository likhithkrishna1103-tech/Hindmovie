package aa;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object[] f657a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f658b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f659c;

    public d0(int i) {
        q.c("initialCapacity", i);
        this.f657a = new Object[i];
        this.f658b = 0;
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
        Object[] objArr = this.f657a;
        int i = this.f658b;
        this.f658b = i + 1;
        objArr[i] = obj;
    }

    public final void b(Object... objArr) {
        int length = objArr.length;
        q.b(length, objArr);
        e(length);
        System.arraycopy(objArr, 0, this.f657a, this.f658b, length);
        this.f658b += length;
    }

    public abstract d0 c(Object obj);

    public final void d(Iterable iterable) {
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            e(collection.size());
            if (collection instanceof e0) {
                this.f658b = ((e0) collection).d(this.f658b, this.f657a);
                return;
            }
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            c(it.next());
        }
    }

    public final void e(int i) {
        Object[] objArr = this.f657a;
        int iF = f(objArr.length, this.f658b + i);
        if (iF > objArr.length || this.f659c) {
            this.f657a = Arrays.copyOf(this.f657a, iF);
            this.f659c = false;
        }
    }
}
