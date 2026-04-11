package d1;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class o extends xd.h implements fe.p {
    public int A;
    public final /* synthetic */ h0 B;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ int f3281z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ o(h0 h0Var, vd.c cVar, int i) {
        super(2, cVar);
        this.f3281z = i;
        this.B = h0Var;
    }

    @Override // fe.p
    public final Object j(Object obj, Object obj2) {
        switch (this.f3281z) {
        }
        return ((o) m((pe.v) obj, (vd.c) obj2)).o(rd.l.f11003a);
    }

    @Override // xd.a
    public final vd.c m(Object obj, vd.c cVar) {
        switch (this.f3281z) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return new o(this.B, cVar, 0);
            case 1:
                return new o(this.B, cVar, 1);
            default:
                return new o(this.B, cVar, 2);
        }
    }

    @Override // xd.a
    public final Object o(Object obj) throws Throwable {
        switch (this.f3281z) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                int i = this.A;
                if (i == 0) {
                    com.bumptech.glide.c.C(obj);
                    this.A = 1;
                    Object objE = h0.e(this.B, this);
                    wd.a aVar = wd.a.f14143v;
                    if (objE == aVar) {
                        return aVar;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    com.bumptech.glide.c.C(obj);
                }
                return rd.l.f11003a;
            case 1:
                int i10 = this.A;
                rd.l lVar = rd.l.f11003a;
                h0 h0Var = this.B;
                wd.a aVar2 = wd.a.f14143v;
                if (i10 == 0) {
                    com.bumptech.glide.c.C(obj);
                    nc.p pVar = h0Var.i;
                    this.A = 1;
                    Object objC0 = ((pe.n) pVar.f9070b).c0(this);
                    if (objC0 != aVar2) {
                        objC0 = lVar;
                    }
                    if (objC0 != aVar2) {
                    }
                    return aVar2;
                }
                if (i10 != 1) {
                    if (i10 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    com.bumptech.glide.c.C(obj);
                    return lVar;
                }
                com.bumptech.glide.c.C(obj);
                se.c cVarD = h0Var.h().d();
                boolean z10 = cVarD instanceof te.e;
                vd.i iVar = vd.i.f13722v;
                re.a aVar3 = re.a.f11005w;
                se.c cVarJ = z10 ? ((te.e) cVarD).j(iVar, 0, aVar3) : new se.b(cVarD, iVar, 0, aVar3, 1);
                t tVar = new t(1, h0Var);
                this.A = 2;
                if (cVarJ.z(tVar, this) != aVar2) {
                    return lVar;
                }
                return aVar2;
            default:
                h0 h0Var2 = this.B;
                p6.d dVar = h0Var2.f3241h;
                int i11 = this.A;
                wd.a aVar4 = wd.a.f14143v;
                try {
                    if (i11 == 0) {
                        com.bumptech.glide.c.C(obj);
                        if (dVar.r() instanceof r0) {
                            return dVar.r();
                        }
                        this.A = 1;
                        if (h0Var2.i(this) == aVar4) {
                            return aVar4;
                        }
                    } else {
                        if (i11 != 1) {
                            if (i11 != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            com.bumptech.glide.c.C(obj);
                            return (l1) obj;
                        }
                        com.bumptech.glide.c.C(obj);
                    }
                    this.A = 2;
                    obj = h0.f(h0Var2, false, this);
                    if (obj == aVar4) {
                        return aVar4;
                    }
                    return (l1) obj;
                } catch (Throwable th) {
                    return new d1(th, -1);
                }
        }
    }
}
