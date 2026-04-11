package k8;

import android.content.ContentValues;
import android.database.sqlite.SQLiteException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class i4 extends t3 {
    public s.e A;
    public Long B;
    public Long C;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f7247y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public HashSet f7248z;

    /* JADX WARN: Code restructure failed: missing block: B:171:0x041e, code lost:
    
        r0 = g().D;
        r2 = k8.p0.v1(r26.f7247y);
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x042e, code lost:
    
        if (r11.v() == false) goto L174;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x0430, code lost:
    
        r4 = java.lang.Integer.valueOf(r11.n());
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x0439, code lost:
    
        r4 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x043a, code lost:
    
        r0.b(r2, java.lang.String.valueOf(r4), "Invalid property filter ID. appId, id");
        r11 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x01dc, code lost:
    
        r18 = r0;
        r19 = r2;
        r23 = r5;
        r24 = r6;
        r22 = r7;
     */
    /* JADX WARN: Removed duplicated region for block: B:135:0x039a  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x039d  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x03a5  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x03a7  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0403 A[LOOP:3: B:49:0x0126->B:169:0x0403, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0418 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void A1(java.util.List r27) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1125
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k8.i4.A1(java.util.List):void");
    }

    public final ArrayList B1() {
        ArrayList arrayList;
        List list;
        ArrayList arrayList2 = new ArrayList();
        s.b<Integer> bVar = (s.b) this.A.keySet();
        bVar.removeAll(this.f7248z);
        for (Integer num : bVar) {
            int iIntValue = num.intValue();
            j4 j4Var = (j4) this.A.get(num);
            t7.v.h(j4Var);
            s.e eVar = j4Var.f7268g;
            s.e eVar2 = j4Var.f;
            com.google.android.gms.internal.measurement.a3 a3VarR = com.google.android.gms.internal.measurement.b3.r();
            a3VarR.e();
            com.google.android.gms.internal.measurement.b3.o((com.google.android.gms.internal.measurement.b3) a3VarR.f3052v, iIntValue);
            boolean z2 = j4Var.f7264b;
            a3VarR.e();
            com.google.android.gms.internal.measurement.b3.q((com.google.android.gms.internal.measurement.b3) a3VarR.f3052v, z2);
            com.google.android.gms.internal.measurement.q3 q3Var = j4Var.f7265c;
            if (q3Var != null) {
                a3VarR.e();
                com.google.android.gms.internal.measurement.b3.s((com.google.android.gms.internal.measurement.b3) a3VarR.f3052v, q3Var);
            }
            com.google.android.gms.internal.measurement.p3 p3VarZ = com.google.android.gms.internal.measurement.q3.z();
            ArrayList arrayListG1 = s0.G1(j4Var.f7266d);
            p3VarZ.e();
            com.google.android.gms.internal.measurement.q3.s((com.google.android.gms.internal.measurement.q3) p3VarZ.f3052v, arrayListG1);
            ArrayList arrayListG12 = s0.G1(j4Var.f7267e);
            p3VarZ.e();
            com.google.android.gms.internal.measurement.q3.y((com.google.android.gms.internal.measurement.q3) p3VarZ.f3052v, arrayListG12);
            if (eVar2 == null) {
                arrayList = null;
            } else {
                arrayList = new ArrayList(eVar2.f11635w);
                for (Integer num2 : (s.b) eVar2.keySet()) {
                    int iIntValue2 = num2.intValue();
                    Long l10 = (Long) eVar2.get(num2);
                    if (l10 != null) {
                        com.google.android.gms.internal.measurement.c3 c3VarR = com.google.android.gms.internal.measurement.d3.r();
                        c3VarR.e();
                        com.google.android.gms.internal.measurement.d3.o((com.google.android.gms.internal.measurement.d3) c3VarR.f3052v, iIntValue2);
                        long jLongValue = l10.longValue();
                        c3VarR.e();
                        com.google.android.gms.internal.measurement.d3.p((com.google.android.gms.internal.measurement.d3) c3VarR.f3052v, jLongValue);
                        arrayList.add((com.google.android.gms.internal.measurement.d3) c3VarR.c());
                    }
                }
            }
            if (arrayList != null) {
                p3VarZ.e();
                com.google.android.gms.internal.measurement.q3.p((com.google.android.gms.internal.measurement.q3) p3VarZ.f3052v, arrayList);
            }
            if (eVar == null) {
                list = Collections.EMPTY_LIST;
            } else {
                ArrayList arrayList3 = new ArrayList(eVar.f11635w);
                Iterator it = ((s.b) eVar.keySet()).iterator();
                while (true) {
                    s.a aVar = (s.a) it;
                    if (!aVar.hasNext()) {
                        break;
                    }
                    Integer num3 = (Integer) aVar.next();
                    com.google.android.gms.internal.measurement.r3 r3VarS = com.google.android.gms.internal.measurement.s3.s();
                    int iIntValue3 = num3.intValue();
                    r3VarS.e();
                    com.google.android.gms.internal.measurement.s3.p((com.google.android.gms.internal.measurement.s3) r3VarS.f3052v, iIntValue3);
                    List list2 = (List) eVar.get(num3);
                    if (list2 != null) {
                        Collections.sort(list2);
                        r3VarS.e();
                        com.google.android.gms.internal.measurement.s3.q((com.google.android.gms.internal.measurement.s3) r3VarS.f3052v, list2);
                    }
                    arrayList3.add((com.google.android.gms.internal.measurement.s3) r3VarS.c());
                }
                list = arrayList3;
            }
            p3VarZ.e();
            com.google.android.gms.internal.measurement.q3.v((com.google.android.gms.internal.measurement.q3) p3VarZ.f3052v, list);
            a3VarR.e();
            com.google.android.gms.internal.measurement.b3.p((com.google.android.gms.internal.measurement.b3) a3VarR.f3052v, (com.google.android.gms.internal.measurement.q3) p3VarZ.c());
            com.google.android.gms.internal.measurement.b3 b3Var = (com.google.android.gms.internal.measurement.b3) a3VarR.c();
            arrayList2.add(b3Var);
            i iVarR1 = r1();
            String str = this.f7247y;
            com.google.android.gms.internal.measurement.q3 q3VarT = b3Var.t();
            iVarR1.t1();
            iVarR1.p1();
            t7.v.d(str);
            t7.v.h(q3VarT);
            byte[] bArrC = q3VarT.c();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("audience_id", num);
            contentValues.put("current_results", bArrC);
            try {
                if (iVarR1.w1().insertWithOnConflict("audience_filter_values", null, contentValues, 5) == -1) {
                    iVarR1.g().A.c(p0.v1(str), "Failed to insert filter results (got -1). appId");
                }
            } catch (SQLiteException e10) {
                iVarR1.g().A.b(p0.v1(str), e10, "Error storing filter results. appId");
            }
        }
        return arrayList2;
    }

    @Override // k8.t3
    public final boolean v1() {
        return false;
    }

    public final ArrayList w1(String str, List list, List list2, Long l10, Long l11) {
        return x1(str, list, list2, l10, l11, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:232:0x05ce  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x05e1  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x05ef  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x022a  */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v6, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.ArrayList x1(java.lang.String r26, java.util.List r27, java.util.List r28, java.lang.Long r29, java.lang.Long r30, boolean r31) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1523
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k8.i4.x1(java.lang.String, java.util.List, java.util.List, java.lang.Long, java.lang.Long, boolean):java.util.ArrayList");
    }

    public final j4 y1(Integer num) {
        if (this.A.containsKey(num)) {
            return (j4) this.A.get(num);
        }
        j4 j4Var = new j4(this, this.f7247y);
        this.A.put(num, j4Var);
        return j4Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x040d  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0416  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x042c  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x05fd  */
    /* JADX WARN: Removed duplicated region for block: B:388:0x08ce A[LOOP:3: B:188:0x0454->B:388:0x08ce, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:395:0x0912  */
    /* JADX WARN: Removed duplicated region for block: B:450:0x08e5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01fd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void z1(java.util.List r45, boolean r46) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 2329
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k8.i4.z1(java.util.List, boolean):void");
    }
}
