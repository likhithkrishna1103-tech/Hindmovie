package hf;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r f6149a = new r(new byte[0], 0, 0, false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f6150b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicReference[] f6151c;

    static {
        int iHighestOneBit = Integer.highestOneBit((Runtime.getRuntime().availableProcessors() * 2) - 1);
        f6150b = iHighestOneBit;
        AtomicReference[] atomicReferenceArr = new AtomicReference[iHighestOneBit];
        for (int i = 0; i < iHighestOneBit; i++) {
            atomicReferenceArr[i] = new AtomicReference();
        }
        f6151c = atomicReferenceArr;
    }

    public static final void a(r rVar) {
        be.h.e(rVar, "segment");
        if (rVar.f != null || rVar.f6148g != null) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (rVar.f6146d) {
            return;
        }
        AtomicReference atomicReference = f6151c[(int) (Thread.currentThread().getId() & (((long) f6150b) - 1))];
        r rVar2 = f6149a;
        r rVar3 = (r) atomicReference.getAndSet(rVar2);
        if (rVar3 == rVar2) {
            return;
        }
        int i = rVar3 != null ? rVar3.f6145c : 0;
        if (i >= 65536) {
            atomicReference.set(rVar3);
            return;
        }
        rVar.f = rVar3;
        rVar.f6144b = 0;
        rVar.f6145c = i + 8192;
        atomicReference.set(rVar);
    }

    public static final r b() {
        AtomicReference atomicReference = f6151c[(int) (Thread.currentThread().getId() & (((long) f6150b) - 1))];
        r rVar = f6149a;
        r rVar2 = (r) atomicReference.getAndSet(rVar);
        if (rVar2 == rVar) {
            return new r();
        }
        if (rVar2 == null) {
            atomicReference.set(null);
            return new r();
        }
        atomicReference.set(rVar2.f);
        rVar2.f = null;
        rVar2.f6145c = 0;
        return rVar2;
    }
}
