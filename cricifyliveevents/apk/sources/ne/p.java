package ne;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class p implements fe.p {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f9146v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Serializable f9147w;

    public /* synthetic */ p(int i, Serializable serializable) {
        this.f9146v = i;
        this.f9147w = serializable;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // fe.p
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object j(java.lang.Object r4, java.lang.Object r5) {
        /*
            r3 = this;
            int r0 = r3.f9146v
            switch(r0) {
                case 0: goto L77;
                default: goto L5;
            }
        L5:
            java.io.Serializable r0 = r3.f9147w
            te.g r0 = (te.g) r0
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r1 = r4.intValue()
            vd.f r5 = (vd.f) r5
            vd.g r4 = r5.getKey()
            vd.h r0 = r0.f12026z
            vd.f r0 = r0.C(r4)
            pe.t r2 = pe.t.f10271w
            if (r4 == r2) goto L27
            if (r5 == r0) goto L24
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            goto L3b
        L24:
            int r1 = r1 + 1
            goto L3b
        L27:
            pe.v0 r0 = (pe.v0) r0
            pe.v0 r5 = (pe.v0) r5
        L2b:
            r4 = 0
            if (r5 != 0) goto L30
            r5 = r4
            goto L37
        L30:
            if (r5 != r0) goto L33
            goto L37
        L33:
            boolean r2 = r5 instanceof ue.q
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
            ue.q r5 = (ue.q) r5
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r2 = pe.c1.f10227w
            java.lang.Object r5 = r2.get(r5)
            pe.k r5 = (pe.k) r5
            if (r5 == 0) goto L75
            pe.v0 r4 = r5.getParent()
        L75:
            r5 = r4
            goto L2b
        L77:
            java.io.Serializable r0 = r3.f9147w
            char[] r0 = (char[]) r0
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            java.lang.String r1 = "$this$DelimitedRangesSequence"
            ge.i.e(r4, r1)
            r1 = 0
            int r4 = ne.h.j0(r4, r0, r5, r1)
            if (r4 >= 0) goto L91
            r4 = 0
            goto La0
        L91:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r5 = 1
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            rd.f r0 = new rd.f
            r0.<init>(r4, r5)
            r4 = r0
        La0:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: ne.p.j(java.lang.Object, java.lang.Object):java.lang.Object");
    }
}
