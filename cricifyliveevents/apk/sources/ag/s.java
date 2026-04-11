package ag;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r f468a = new r(new byte[0], 0, 0, false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f469b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicReference[] f470c;

    static {
        int iHighestOneBit = Integer.highestOneBit((Runtime.getRuntime().availableProcessors() * 2) - 1);
        f469b = iHighestOneBit;
        AtomicReference[] atomicReferenceArr = new AtomicReference[iHighestOneBit];
        for (int i = 0; i < iHighestOneBit; i++) {
            atomicReferenceArr[i] = new AtomicReference();
        }
        f470c = atomicReferenceArr;
    }

    public static final void a(r rVar) {
        ge.i.e(rVar, "segment");
        if (rVar.f != null || rVar.f467g != null) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (rVar.f465d) {
            return;
        }
        AtomicReference atomicReference = f470c[(int) (Thread.currentThread().getId() & (((long) f469b) - 1))];
        r rVar2 = f468a;
        r rVar3 = (r) atomicReference.getAndSet(rVar2);
        if (rVar3 == rVar2) {
            return;
        }
        int i = rVar3 != null ? rVar3.f464c : 0;
        if (i >= 65536) {
            atomicReference.set(rVar3);
            return;
        }
        rVar.f = rVar3;
        rVar.f463b = 0;
        rVar.f464c = i + 8192;
        atomicReference.set(rVar);
    }

    public static final r b() {
        AtomicReference atomicReference = f470c[(int) (Thread.currentThread().getId() & (((long) f469b) - 1))];
        r rVar = f468a;
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
        rVar2.f464c = 0;
        return rVar2;
    }
}
