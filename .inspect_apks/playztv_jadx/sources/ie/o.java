package ie;

import ae.p;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class o implements p {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f6615u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ Serializable f6616v;

    public /* synthetic */ o(int i, Serializable serializable) {
        this.f6615u = i;
        this.f6616v = serializable;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // ae.p
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object i(java.lang.Object r4, java.lang.Object r5) {
        /*
            r3 = this;
            int r0 = r3.f6615u
            switch(r0) {
                case 0: goto L77;
                default: goto L5;
            }
        L5:
            java.io.Serializable r0 = r3.f6616v
            oe.f r0 = (oe.f) r0
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r1 = r4.intValue()
            rd.f r5 = (rd.f) r5
            rd.g r4 = r5.getKey()
            rd.h r0 = r0.f9583y
            rd.f r0 = r0.v(r4)
            ke.s r2 = ke.s.f7730v
            if (r4 == r2) goto L27
            if (r5 == r0) goto L24
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            goto L3b
        L24:
            int r1 = r1 + 1
            goto L3b
        L27:
            ke.v0 r0 = (ke.v0) r0
            ke.v0 r5 = (ke.v0) r5
        L2b:
            r4 = 0
            if (r5 != 0) goto L30
            r5 = r4
            goto L37
        L30:
            if (r5 != r0) goto L33
            goto L37
        L33:
            boolean r2 = r5 instanceof pe.q
            if (r2 != 0) goto L65
        L37:
            if (r5 != r0) goto L40
            if (r0 != 0) goto L24
        L3b:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r1)
            return r4
        L40:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Flow invariant is violated:\n\t\tEmission from another coroutine is detected.\n\t\tChild of "
            r1.<init>(r2)
            r1.append(r5)
            java.lang.String r5 = ", expected child of "
            r1.append(r5)
            r1.append(r0)
            java.lang.String r5 = ".\n\t\tFlowCollector is not thread-safe and concurrent emissions are prohibited.\n\t\tTo mitigate this restriction please use 'channelFlow' builder instead of 'flow'"
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            java.lang.String r5 = r5.toString()
            r4.<init>(r5)
            throw r4
        L65:
            pe.q r5 = (pe.q) r5
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r2 = ke.d1.f7687v
            java.lang.Object r5 = r2.get(r5)
            ke.j r5 = (ke.j) r5
            if (r5 == 0) goto L75
            ke.v0 r4 = r5.getParent()
        L75:
            r5 = r4
            goto L2b
        L77:
            java.io.Serializable r0 = r3.f6616v
            char[] r0 = (char[]) r0
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            java.lang.String r1 = "$this$DelimitedRangesSequence"
            be.h.e(r4, r1)
            r1 = 0
            int r4 = ie.e.T(r4, r0, r5, r1)
            if (r4 >= 0) goto L91
            r4 = 0
            goto La0
        L91:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r5 = 1
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            nd.f r0 = new nd.f
            r0.<init>(r4, r5)
            r4 = r0
        La0:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: ie.o.i(java.lang.Object, java.lang.Object):java.lang.Object");
    }
}
