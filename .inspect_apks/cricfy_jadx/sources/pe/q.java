package pe;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class q implements fe.p {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f10264v;

    public /* synthetic */ q(int i) {
        this.f10264v = i;
    }

    @Override // fe.p
    public final Object j(Object obj, Object obj2) {
        vd.b bVar;
        switch (this.f10264v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                Boolean bool = (Boolean) obj;
                bool.booleanValue();
                return bool;
            case 1:
                return ((vd.h) obj).q((vd.f) obj2);
            case 2:
                return ((vd.h) obj).q((vd.f) obj2);
            case 3:
                return Integer.valueOf(((Integer) obj).intValue() + 1);
            case g1.h.LONG_FIELD_NUMBER /* 4 */:
                vd.f fVar = (vd.f) obj2;
                if (!(fVar instanceof ue.u)) {
                    return obj;
                }
                Integer num = obj instanceof Integer ? (Integer) obj : null;
                int iIntValue = num != null ? num.intValue() : 1;
                return iIntValue == 0 ? fVar : Integer.valueOf(iIntValue + 1);
            case g1.h.STRING_FIELD_NUMBER /* 5 */:
                ue.u uVar = (ue.u) obj;
                vd.f fVar2 = (vd.f) obj2;
                if (uVar != null) {
                    return uVar;
                }
                if (fVar2 instanceof ue.u) {
                    return (ue.u) fVar2;
                }
                return null;
            case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                ue.x xVar = (ue.x) obj;
                vd.f fVar3 = (vd.f) obj2;
                if (fVar3 instanceof ue.u) {
                    ue.u uVar2 = (ue.u) fVar3;
                    Object objC = uVar2.c(xVar.f12494a);
                    Object[] objArr = xVar.f12495b;
                    int i = xVar.f12497d;
                    objArr[i] = objC;
                    ue.u[] uVarArr = xVar.f12496c;
                    xVar.f12497d = i + 1;
                    uVarArr[i] = uVar2;
                }
                return xVar;
            case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                String str = (String) obj;
                vd.f fVar4 = (vd.f) obj2;
                ge.i.e(str, "acc");
                ge.i.e(fVar4, "element");
                if (str.length() == 0) {
                    return fVar4.toString();
                }
                return str + ", " + fVar4;
            default:
                vd.h hVar = (vd.h) obj;
                vd.f fVar5 = (vd.f) obj2;
                ge.i.e(hVar, "acc");
                ge.i.e(fVar5, "element");
                vd.h hVarO = hVar.O(fVar5.getKey());
                vd.i iVar = vd.i.f13722v;
                if (hVarO == iVar) {
                    return fVar5;
                }
                vd.d dVar = vd.d.f13721v;
                vd.e eVar = (vd.e) hVarO.C(dVar);
                if (eVar == null) {
                    bVar = new vd.b(fVar5, hVarO);
                } else {
                    vd.h hVarO2 = hVarO.O(dVar);
                    if (hVarO2 == iVar) {
                        return new vd.b(eVar, fVar5);
                    }
                    bVar = new vd.b(eVar, new vd.b(fVar5, hVarO2));
                }
                return bVar;
        }
    }
}
