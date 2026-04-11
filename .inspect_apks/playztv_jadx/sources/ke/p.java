package ke;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class p implements ae.p {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f7723u;

    public /* synthetic */ p(int i) {
        this.f7723u = i;
    }

    @Override // ae.p
    public final Object i(Object obj, Object obj2) {
        rd.b bVar;
        switch (this.f7723u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                Boolean bool = (Boolean) obj;
                bool.booleanValue();
                return bool;
            case 1:
                return ((rd.h) obj).K((rd.f) obj2);
            case 2:
                return ((rd.h) obj).K((rd.f) obj2);
            case 3:
                return Integer.valueOf(((Integer) obj).intValue() + 1);
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                rd.f fVar = (rd.f) obj2;
                if (!(fVar instanceof pe.u)) {
                    return obj;
                }
                Integer num = obj instanceof Integer ? (Integer) obj : null;
                int iIntValue = num != null ? num.intValue() : 1;
                return iIntValue == 0 ? fVar : Integer.valueOf(iIntValue + 1);
            case b1.j.STRING_FIELD_NUMBER /* 5 */:
                pe.u uVar = (pe.u) obj;
                rd.f fVar2 = (rd.f) obj2;
                if (uVar != null) {
                    return uVar;
                }
                if (fVar2 instanceof pe.u) {
                    return (pe.u) fVar2;
                }
                return null;
            case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                pe.x xVar = (pe.x) obj;
                rd.f fVar3 = (rd.f) obj2;
                if (fVar3 instanceof pe.u) {
                    pe.u uVar2 = (pe.u) fVar3;
                    Object objC = uVar2.c(xVar.f10408a);
                    Object[] objArr = xVar.f10409b;
                    int i = xVar.f10411d;
                    objArr[i] = objC;
                    pe.u[] uVarArr = xVar.f10410c;
                    xVar.f10411d = i + 1;
                    uVarArr[i] = uVar2;
                }
                return xVar;
            case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                String str = (String) obj;
                rd.f fVar4 = (rd.f) obj2;
                be.h.e(str, "acc");
                be.h.e(fVar4, "element");
                if (str.length() == 0) {
                    return fVar4.toString();
                }
                return str + ", " + fVar4;
            default:
                rd.h hVar = (rd.h) obj;
                rd.f fVar5 = (rd.f) obj2;
                be.h.e(hVar, "acc");
                be.h.e(fVar5, "element");
                rd.h hVarG = hVar.G(fVar5.getKey());
                rd.i iVar = rd.i.f11572u;
                if (hVarG == iVar) {
                    return fVar5;
                }
                rd.d dVar = rd.d.f11571u;
                rd.e eVar = (rd.e) hVarG.v(dVar);
                if (eVar == null) {
                    bVar = new rd.b(fVar5, hVarG);
                } else {
                    rd.h hVarG2 = hVarG.G(dVar);
                    if (hVarG2 == iVar) {
                        return new rd.b(eVar, fVar5);
                    }
                    bVar = new rd.b(eVar, new rd.b(fVar5, hVarG2));
                }
                return bVar;
        }
    }
}
