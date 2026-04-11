package zc;

import a2.y0;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.util.Pair;
import be.h;
import c2.w;
import c7.n;
import c7.t;
import com.tonyodev.fetch2.database.DownloadDatabase;
import e6.j;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import na.p;
import na.r;
import na.s;
import s1.b0;
import ue.m;
import ue.o;
import ue.v;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c implements e7.b, na.c, t3.d {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Object f14945u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Object f14946v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Object f14947w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Object f14948x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Object f14949y;

    public /* synthetic */ c(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        this.f14945u = obj;
        this.f14946v = obj2;
        this.f14947w = obj3;
        this.f14948x = obj4;
        this.f14949y = obj5;
    }

    public static c n(SharedPreferences sharedPreferences, ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        c cVar = new c();
        cVar.f14948x = new ArrayDeque();
        cVar.f14945u = sharedPreferences;
        cVar.f14946v = "topic_operation_queue";
        cVar.f14947w = ",";
        cVar.f14949y = scheduledThreadPoolExecutor;
        synchronized (((ArrayDeque) cVar.f14948x)) {
            try {
                ((ArrayDeque) cVar.f14948x).clear();
                String string = ((SharedPreferences) cVar.f14945u).getString((String) cVar.f14946v, "");
                if (!TextUtils.isEmpty(string) && string.contains((String) cVar.f14947w)) {
                    String[] strArrSplit = string.split((String) cVar.f14947w, -1);
                    if (strArrSplit.length == 0) {
                        Log.e("FirebaseMessaging", "Corrupted queue. Please check the queue contents and item separator provided");
                    }
                    for (String str : strArrSplit) {
                        if (!TextUtils.isEmpty(str)) {
                            ((ArrayDeque) cVar.f14948x).add(str);
                        }
                    }
                    return cVar;
                }
                return cVar;
            } finally {
            }
        }
    }

    @Override // t3.d
    public int a(long j5) {
        long[] jArr = (long[]) this.f14946v;
        int iA = b0.a(jArr, j5, false);
        if (iA < jArr.length) {
            return iA;
        }
        return -1;
    }

    @Override // na.c
    public Object b(Class cls) {
        if (!((Set) this.f14945u).contains(r.a(cls))) {
            throw new y0("Attempting to request an undeclared dependency " + cls + ".");
        }
        Object objB = ((na.c) this.f14949y).b(cls);
        if (!cls.equals(kb.b.class)) {
            return objB;
        }
        return new s();
    }

    @Override // na.c
    public Set c(r rVar) {
        if (((Set) this.f14948x).contains(rVar)) {
            return ((na.c) this.f14949y).c(rVar);
        }
        throw new y0("Attempting to request an undeclared dependency Set<" + rVar + ">.");
    }

    @Override // na.c
    public Object d(r rVar) {
        if (((Set) this.f14945u).contains(rVar)) {
            return ((na.c) this.f14949y).d(rVar);
        }
        throw new y0("Attempting to request an undeclared dependency " + rVar + ".");
    }

    @Override // na.c
    public nb.b e(Class cls) {
        return g(r.a(cls));
    }

    @Override // t3.d
    public long f(int i) {
        return ((long[]) this.f14946v)[i];
    }

    @Override // na.c
    public nb.b g(r rVar) {
        if (((Set) this.f14946v).contains(rVar)) {
            return ((na.c) this.f14949y).g(rVar);
        }
        throw new y0("Attempting to request an undeclared dependency Provider<" + rVar + ">.");
    }

    @Override // md.a
    public Object get() {
        return new h7.a((Executor) ((md.a) this.f14945u).get(), (d7.d) ((md.a) this.f14946v).get(), (a7.b) ((a7.b) this.f14947w).get(), (j7.d) ((md.a) this.f14948x).get(), (k7.c) ((md.a) this.f14949y).get());
    }

    @Override // na.c
    public p h(r rVar) {
        if (((Set) this.f14947w).contains(rVar)) {
            return ((na.c) this.f14949y).h(rVar);
        }
        throw new y0("Attempting to request an undeclared dependency Deferred<" + rVar + ">.");
    }

    @Override // t3.d
    public List i(long j5) {
        z3.c cVar = (z3.c) this.f14945u;
        Map map = (Map) this.f14947w;
        HashMap map2 = (HashMap) this.f14948x;
        HashMap map3 = (HashMap) this.f14949y;
        ArrayList arrayList = new ArrayList();
        cVar.g(j5, cVar.f14826h, arrayList);
        TreeMap treeMap = new TreeMap();
        cVar.i(j5, false, cVar.f14826h, treeMap);
        cVar.h(j5, map, map2, cVar.f14826h, treeMap);
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            Pair pair = (Pair) obj;
            String str = (String) map3.get(pair.second);
            if (str != null) {
                byte[] bArrDecode = Base64.decode(str, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                z3.f fVar = (z3.f) map2.get(pair.first);
                fVar.getClass();
                arrayList2.add(new r1.b(null, null, null, bitmapDecodeByteArray, fVar.f14842c, 0, fVar.f14844e, fVar.f14841b, 0, Integer.MIN_VALUE, -3.4028235E38f, fVar.f, fVar.f14845g, false, -16777216, fVar.f14847j, 0.0f, 0));
            }
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            z3.f fVar2 = (z3.f) map2.get(entry.getKey());
            fVar2.getClass();
            r1.a aVar = (r1.a) entry.getValue();
            CharSequence charSequence = aVar.f11229a;
            charSequence.getClass();
            SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) charSequence;
            for (z3.a aVar2 : (z3.a[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), z3.a.class)) {
                spannableStringBuilder.replace(spannableStringBuilder.getSpanStart(aVar2), spannableStringBuilder.getSpanEnd(aVar2), (CharSequence) "");
            }
            for (int i10 = 0; i10 < spannableStringBuilder.length(); i10++) {
                if (spannableStringBuilder.charAt(i10) == ' ') {
                    int i11 = i10 + 1;
                    int i12 = i11;
                    while (i12 < spannableStringBuilder.length() && spannableStringBuilder.charAt(i12) == ' ') {
                        i12++;
                    }
                    int i13 = i12 - i11;
                    if (i13 > 0) {
                        spannableStringBuilder.delete(i10, i13 + i10);
                    }
                }
            }
            if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(0) == ' ') {
                spannableStringBuilder.delete(0, 1);
            }
            for (int i14 = 0; i14 < spannableStringBuilder.length() - 1; i14++) {
                if (spannableStringBuilder.charAt(i14) == '\n') {
                    int i15 = i14 + 1;
                    if (spannableStringBuilder.charAt(i15) == ' ') {
                        spannableStringBuilder.delete(i15, i14 + 2);
                    }
                }
            }
            if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) == ' ') {
                spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
            }
            for (int i16 = 0; i16 < spannableStringBuilder.length() - 1; i16++) {
                if (spannableStringBuilder.charAt(i16) == ' ') {
                    int i17 = i16 + 1;
                    if (spannableStringBuilder.charAt(i17) == '\n') {
                        spannableStringBuilder.delete(i16, i17);
                    }
                }
            }
            if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) == '\n') {
                spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
            }
            float f = fVar2.f14842c;
            int i18 = fVar2.f14843d;
            aVar.f11233e = f;
            aVar.f = i18;
            aVar.f11234g = fVar2.f14844e;
            aVar.f11235h = fVar2.f14841b;
            aVar.f11238l = fVar2.f;
            float f4 = fVar2.i;
            int i19 = fVar2.f14846h;
            aVar.f11237k = f4;
            aVar.f11236j = i19;
            aVar.f11242p = fVar2.f14847j;
            arrayList2.add(aVar.a());
        }
        return arrayList2;
    }

    @Override // t3.d
    public int j() {
        return ((long[]) this.f14946v).length;
    }

    public boolean k(String str) {
        boolean zAdd;
        if (TextUtils.isEmpty(str) || str.contains((String) this.f14947w)) {
            return false;
        }
        synchronized (((ArrayDeque) this.f14948x)) {
            zAdd = ((ArrayDeque) this.f14948x).add(str);
            if (zAdd) {
                ((ScheduledThreadPoolExecutor) this.f14949y).execute(new nc.b(8, this));
            }
        }
        return zAdd;
    }

    public void l(String str, String str2) {
        h.e(str, "name");
        h.e(str2, "value");
        q2.d dVar = (q2.d) this.f14947w;
        dVar.getClass();
        h.e(str, "name");
        h.e(str2, "value");
        v.a(str);
        v.b(str2, str);
        dVar.f(str, str2);
    }

    public b2.g m() {
        Map mapUnmodifiableMap;
        o oVar = (o) this.f14945u;
        if (oVar == null) {
            throw new IllegalStateException("url == null");
        }
        String str = (String) this.f14946v;
        m mVarG = ((q2.d) this.f14947w).g();
        v vVar = (v) this.f14948x;
        LinkedHashMap linkedHashMap = (LinkedHashMap) this.f14949y;
        byte[] bArr = ve.b.f13497a;
        h.e(linkedHashMap, "<this>");
        if (linkedHashMap.isEmpty()) {
            mapUnmodifiableMap = od.r.f9571u;
        } else {
            mapUnmodifiableMap = Collections.unmodifiableMap(new LinkedHashMap(linkedHashMap));
            h.d(mapUnmodifiableMap, "{\n    Collections.unmodi…(LinkedHashMap(this))\n  }");
        }
        return new b2.g(oVar, str, mVarG, vVar, mapUnmodifiableMap);
    }

    public p o(Class cls) {
        return h(r.a(cls));
    }

    public void p(String str, String str2) {
        h.e(str, "name");
        h.e(str2, "value");
        q2.d dVar = (q2.d) this.f14947w;
        dVar.getClass();
        v.a(str);
        v.b(str2, str);
        dVar.i(str);
        dVar.f(str, str2);
    }

    public void q(String str, v vVar) {
        h.e(str, "method");
        if (str.length() <= 0) {
            throw new IllegalArgumentException("method.isEmpty() == true");
        }
        if (vVar == null) {
            if (str.equals("POST") || str.equals("PUT") || str.equals("PATCH") || str.equals("PROPPATCH") || str.equals("REPORT")) {
                throw new IllegalArgumentException(j.n("method ", str, " must have a request body.").toString());
            }
        } else if (!android.support.v4.media.session.b.L(str)) {
            throw new IllegalArgumentException(j.n("method ", str, " must not have a request body.").toString());
        }
        this.f14946v = str;
        this.f14948x = vVar;
    }

    public String r() {
        String str;
        synchronized (((ArrayDeque) this.f14948x)) {
            str = (String) ((ArrayDeque) this.f14948x).peek();
        }
        return str;
    }

    public boolean s(Object obj) {
        boolean zRemove;
        synchronized (((ArrayDeque) this.f14948x)) {
            zRemove = ((ArrayDeque) this.f14948x).remove(obj);
            if (zRemove) {
                ((ScheduledThreadPoolExecutor) this.f14949y).execute(new nc.b(8, this));
            }
        }
        return zRemove;
    }

    public void t(z6.a aVar, z6.g gVar) {
        t tVar = (t) this.f14949y;
        c7.j jVar = (c7.j) this.f14945u;
        String str = (String) this.f14946v;
        z6.e eVar = (z6.e) this.f14948x;
        if (eVar == null) {
            throw new NullPointerException("Null transformer");
        }
        z6.c cVar = (z6.c) this.f14947w;
        h7.b bVar = tVar.f2584c;
        c7.j jVarB = jVar.b(aVar.f14887b);
        c7.h hVar = new c7.h();
        hVar.f2550h = new HashMap();
        hVar.f = Long.valueOf(tVar.f2582a.g());
        hVar.f2549g = Long.valueOf(tVar.f2583b.g());
        hVar.f2544a = str;
        hVar.f2548e = new n(cVar, (byte[]) eVar.apply(aVar.f14886a));
        hVar.f2546c = null;
        z6.b bVar2 = aVar.f14888c;
        if (bVar2 != null) {
            hVar.f2547d = bVar2.f14889a;
        }
        h7.a aVar2 = (h7.a) bVar;
        aVar2.f5957b.execute(new w(aVar2, jVarB, gVar, hVar.c(), 7));
    }

    public Set u(Class cls) {
        return c(r.a(cls));
    }

    public void v(String str) {
        h.e(str, "url");
        if (ie.n.M(str, "ws:", true)) {
            String strSubstring = str.substring(3);
            h.d(strSubstring, "this as java.lang.String).substring(startIndex)");
            str = "http:".concat(strSubstring);
        } else if (ie.n.M(str, "wss:", true)) {
            String strSubstring2 = str.substring(4);
            h.d(strSubstring2, "this as java.lang.String).substring(startIndex)");
            str = "https:".concat(strSubstring2);
        }
        h.e(str, "<this>");
        ue.n nVar = new ue.n();
        nVar.c(null, str);
        this.f14945u = nVar.a();
    }

    public c(z3.c cVar, HashMap map, HashMap map2, HashMap map3) {
        this.f14945u = cVar;
        this.f14948x = map2;
        this.f14949y = map3;
        this.f14947w = Collections.unmodifiableMap(map);
        TreeSet treeSet = new TreeSet();
        int i = 0;
        cVar.d(treeSet, false);
        long[] jArr = new long[treeSet.size()];
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            jArr[i] = ((Long) it.next()).longValue();
            i++;
        }
        this.f14946v = jArr;
    }

    public c(DownloadDatabase downloadDatabase) {
        this.f14947w = new ua.c();
        this.f14945u = downloadDatabase;
        this.f14946v = new a(this, downloadDatabase);
        this.f14948x = new b(downloadDatabase);
        this.f14949y = new b(this, downloadDatabase);
        new a(downloadDatabase);
    }

    public c(String str, LinkedHashMap linkedHashMap, String str2, Uri uri, String str3, id.g gVar) {
        h.e(str, "url");
        h.e(str2, "file");
        h.e(gVar, "extras");
        this.f14945u = str;
        this.f14946v = linkedHashMap;
        this.f14947w = str2;
        this.f14948x = str3;
        this.f14949y = gVar;
    }

    public c() {
        this.f14949y = new LinkedHashMap();
        this.f14946v = "GET";
        this.f14947w = new q2.d(2);
    }
}
