package n;

import android.content.ContentProviderClient;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Surface;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.behavior.SwipeDismissBehavior;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class a1 implements z0, n0.a, lc.b, ne.b, o8.e, ra.a, s2.h, r0.o, u2.d0 {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Object f8343u;

    public /* synthetic */ a1(Object obj) {
        this.f8343u = obj;
    }

    public static n7.a A(a5.d dVar) throws Exception {
        HashMap map = new HashMap(20);
        map.put("_id", new w4.d(1, 1, "_id", "INTEGER", null, true));
        map.put("_namespace", new w4.d(0, 1, "_namespace", "TEXT", null, true));
        map.put("_url", new w4.d(0, 1, "_url", "TEXT", null, true));
        map.put("_file", new w4.d(0, 1, "_file", "TEXT", null, true));
        map.put("_group", new w4.d(0, 1, "_group", "INTEGER", null, true));
        map.put("_priority", new w4.d(0, 1, "_priority", "INTEGER", null, true));
        map.put("_headers", new w4.d(0, 1, "_headers", "TEXT", null, true));
        map.put("_written_bytes", new w4.d(0, 1, "_written_bytes", "INTEGER", null, true));
        map.put("_total_bytes", new w4.d(0, 1, "_total_bytes", "INTEGER", null, true));
        map.put("_status", new w4.d(0, 1, "_status", "INTEGER", null, true));
        map.put("_error", new w4.d(0, 1, "_error", "INTEGER", null, true));
        map.put("_network_type", new w4.d(0, 1, "_network_type", "INTEGER", null, true));
        map.put("_created", new w4.d(0, 1, "_created", "INTEGER", null, true));
        map.put("_tag", new w4.d(0, 1, "_tag", "TEXT", null, false));
        map.put("_enqueue_action", new w4.d(0, 1, "_enqueue_action", "INTEGER", null, true));
        map.put("_identifier", new w4.d(0, 1, "_identifier", "INTEGER", null, true));
        map.put("_download_on_enqueue", new w4.d(0, 1, "_download_on_enqueue", "INTEGER", null, true));
        map.put("_extras", new w4.d(0, 1, "_extras", "TEXT", null, true));
        map.put("_auto_retry_max_attempts", new w4.d(0, 1, "_auto_retry_max_attempts", "INTEGER", null, true));
        map.put("_auto_retry_attempts", new w4.d(0, 1, "_auto_retry_attempts", "INTEGER", null, true));
        HashSet hashSet = new HashSet(0);
        HashSet hashSet2 = new HashSet(2);
        hashSet2.add(new w4.f("index_requests__file", true, Arrays.asList("_file"), Arrays.asList("ASC")));
        hashSet2.add(new w4.f("index_requests__group__status", false, Arrays.asList("_group", "_status"), Arrays.asList("ASC", "ASC")));
        w4.g gVar = new w4.g("requests", map, hashSet, hashSet2);
        w4.g gVarW = cf.d.w(new u4.a(dVar), "requests");
        if (gVar.equals(gVarW)) {
            return new n7.a(true, (String) null, 2);
        }
        return new n7.a(false, "requests(com.tonyodev.fetch2.database.DownloadInfo).\n Expected:\n" + gVar + "\n Found:\n" + gVarW, 2);
    }

    public static void B(File file) {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        for (File file2 : fileArrListFiles) {
            if (file2.isDirectory()) {
                B(file2);
            } else if (file2.getName().toLowerCase(Locale.US).endsWith(".apk")) {
                file2.delete();
            }
        }
    }

    public static File t(Context context, String str) {
        String lastPathSegment;
        try {
            lastPathSegment = Uri.parse(str).getLastPathSegment();
        } catch (Exception unused) {
        }
        if (TextUtils.isEmpty(lastPathSegment)) {
            lastPathSegment = "PlayZTv.apk";
        } else {
            if (lastPathSegment.contains("?")) {
                lastPathSegment = lastPathSegment.substring(0, lastPathSegment.indexOf(63));
            }
            if (!lastPathSegment.toLowerCase().endsWith(".apk")) {
                lastPathSegment = lastPathSegment.concat(".apk");
            }
        }
        return new File(context.getExternalFilesDir(null), lastPathSegment);
    }

    public static void v(Context context, File file) {
        f0.d dVarC = FileProvider.c(context, context.getPackageName() + ".provider");
        try {
            String canonicalPath = file.getCanonicalPath();
            Map.Entry entry = null;
            for (Map.Entry entry2 : dVarC.f4690b.entrySet()) {
                String path = ((File) entry2.getValue()).getPath();
                if (FileProvider.a(canonicalPath).startsWith(FileProvider.a(path) + '/') && (entry == null || path.length() > ((File) entry.getValue()).getPath().length())) {
                    entry = entry2;
                }
            }
            if (entry == null) {
                throw new IllegalArgumentException(l4.a.m("Failed to find configured root that contains ", canonicalPath));
            }
            String path2 = ((File) entry.getValue()).getPath();
            Uri uriBuild = new Uri.Builder().scheme("content").authority(dVarC.f4689a).encodedPath(Uri.encode((String) entry.getKey()) + '/' + Uri.encode(path2.endsWith("/") ? canonicalPath.substring(path2.length()) : canonicalPath.substring(path2.length() + 1), "/")).build();
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(uriBuild, "application/vnd.android.package-archive");
            intent.setFlags(268435456);
            intent.addFlags(1);
            context.startActivity(intent);
        } catch (IOException unused) {
            throw new IllegalArgumentException("Failed to resolve canonical path for " + file);
        }
    }

    public static a1 x(int i, int i10, int i11) {
        return new a1(AccessibilityNodeInfo.CollectionInfo.obtain(i, i10, false, i11));
    }

    public void C(wb.c cVar) {
        dd.p pVar = new dd.p(this, cVar);
        dd.h hVar = (dd.h) this.f8343u;
        hVar.getClass();
        synchronized (hVar.f) {
            ((id.k) hVar.f4151a).d(new dd.b(hVar, 0, pVar));
        }
    }

    @Override // o8.e
    public void c(Object obj) {
        ((o8.h) ((a1) this.f8343u).f8343u).f9421a.n();
    }

    @Override // n0.a
    public void close() {
        ContentProviderClient contentProviderClient = (ContentProviderClient) this.f8343u;
        if (contentProviderClient != null) {
            contentProviderClient.release();
        }
    }

    @Override // s2.h
    public void d(s2.j jVar, long j5, long j8) {
        boolean z2;
        d2.d dVar = (d2.d) this.f8343u;
        synchronized (t2.b.f12068b) {
            z2 = t2.b.f12069c;
        }
        if (z2) {
            dVar.a();
        } else {
            dVar.f3708u.B(new IOException(new ConcurrentModificationException()));
        }
    }

    @Override // r0.o
    public boolean e(View view) {
        SwipeDismissBehavior swipeDismissBehavior = (SwipeDismissBehavior) this.f8343u;
        if (!swipeDismissBehavior.w(view)) {
            return false;
        }
        WeakHashMap weakHashMap = q0.o0.f10475a;
        boolean z2 = view.getLayoutDirection() == 1;
        int i = swipeDismissBehavior.f3332x;
        view.offsetLeftAndRight((!(i == 0 && z2) && (i != 1 || z2)) ? view.getWidth() : -view.getWidth());
        view.setAlpha(0.0f);
        return true;
    }

    @Override // u2.d0
    public void f() {
        u2.j jVar = (u2.j) this.f8343u;
        Surface surface = jVar.f12606r1;
        if (surface != null) {
            jVar.f12592d1.n(surface);
            jVar.f12609u1 = true;
        }
    }

    @Override // u2.d0
    public void g() {
        u2.j jVar = (u2.j) this.f8343u;
        if (jVar.f12606r1 != null) {
            jVar.N0(0, 1);
        }
    }

    @Override // n0.a
    public Cursor h(Uri uri, String[] strArr, String[] strArr2) {
        ContentProviderClient contentProviderClient = (ContentProviderClient) this.f8343u;
        if (contentProviderClient == null) {
            return null;
        }
        try {
            return contentProviderClient.query(uri, strArr, "query = ?", strArr2, null, null);
        } catch (RemoteException e10) {
            Log.w("FontsProvider", "Unable to query the content provider", e10);
            return null;
        }
    }

    @Override // u2.d0
    public void i() {
        a2.r0 r0Var = ((u2.j) this.f8343u).f6730b0;
        if (r0Var != null) {
            r0Var.a();
        }
    }

    @Override // lc.b
    public void l(String str, String str2, String str3, String str4) {
        oc.h hVar = new oc.h(str, str2, str3, str4, !TextUtils.isEmpty(str3));
        nc.u uVar = (nc.u) this.f8343u;
        uVar.f8973t0.add(hVar);
        ic.u uVar2 = uVar.f8972s0;
        uVar2.f.add(hVar);
        uVar2.f10982a.d(uVar2.f.size());
    }

    @Override // s2.h
    public e4.f m(s2.j jVar, long j5, long j8, IOException iOException, int i) {
        ((d2.d) this.f8343u).f3708u.B(iOException);
        return s2.m.f11765y;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ne.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object o(ne.c r6, td.c r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof ne.a
            if (r0 == 0) goto L13
            r0 = r7
            ne.a r0 = (ne.a) r0
            int r1 = r0.A
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.A = r1
            goto L18
        L13:
            ne.a r0 = new ne.a
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f8994y
            int r1 = r0.A
            nd.k r2 = nd.k.f8990a
            r3 = 1
            if (r1 == 0) goto L33
            if (r1 != r3) goto L2b
            oe.f r6 = r0.f8993x
            i5.a.Q(r7)     // Catch: java.lang.Throwable -> L29
            goto L56
        L29:
            r7 = move-exception
            goto L60
        L2b:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L33:
            i5.a.Q(r7)
            oe.f r7 = new oe.f
            rd.h r1 = r0.f12489v
            be.h.b(r1)
            r7.<init>(r6, r1)
            r0.f8993x = r7     // Catch: java.lang.Throwable -> L5e
            r0.A = r3     // Catch: java.lang.Throwable -> L5e
            java.lang.Object r6 = r5.f8343u     // Catch: java.lang.Throwable -> L5e
            z0.o r6 = (z0.o) r6     // Catch: java.lang.Throwable -> L5e
            java.lang.Object r6 = r6.i(r7, r0)     // Catch: java.lang.Throwable -> L5e
            sd.a r0 = sd.a.f11942u
            if (r6 != r0) goto L51
            goto L52
        L51:
            r6 = r2
        L52:
            if (r6 != r0) goto L55
            return r0
        L55:
            r6 = r7
        L56:
            r6.p()
            return r2
        L5a:
            r4 = r7
            r7 = r6
            r6 = r4
            goto L60
        L5e:
            r6 = move-exception
            goto L5a
        L60:
            r6.p()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: n.a1.o(ne.c, td.c):java.lang.Object");
    }

    @Override // ra.a
    public void p(Bundle bundle) {
        ((ka.c) ((ka.b) this.f8343u)).a("clx", "_ae", bundle);
    }

    public void q(ad.a aVar) {
        be.h.e(aVar, "migration");
        int i = aVar.f792a;
        int i10 = aVar.f793b;
        LinkedHashMap linkedHashMap = (LinkedHashMap) this.f8343u;
        Integer numValueOf = Integer.valueOf(i);
        Object treeMap = linkedHashMap.get(numValueOf);
        if (treeMap == null) {
            treeMap = new TreeMap();
            linkedHashMap.put(numValueOf, treeMap);
        }
        TreeMap treeMap2 = (TreeMap) treeMap;
        if (treeMap2.containsKey(Integer.valueOf(i10))) {
            Log.w("ROOM", "Overriding migration " + treeMap2.get(Integer.valueOf(i10)) + " with " + aVar);
        }
        treeMap2.put(Integer.valueOf(i10), aVar);
    }

    public void r(q4.a aVar) {
        RecyclerView recyclerView = (RecyclerView) this.f8343u;
        int i = aVar.f10737a;
        if (i == 1) {
            recyclerView.H.Z(aVar.f10738b, aVar.f10740d);
            return;
        }
        if (i == 2) {
            recyclerView.H.c0(aVar.f10738b, aVar.f10740d);
        } else if (i == 4) {
            recyclerView.H.d0(aVar.f10738b, aVar.f10740d);
        } else {
            if (i != 8) {
                return;
            }
            recyclerView.H.b0(aVar.f10738b, aVar.f10740d);
        }
    }

    public q4.x0 s(int i) {
        RecyclerView recyclerView = (RecyclerView) this.f8343u;
        int iL = recyclerView.f1672z.l();
        int i10 = 0;
        q4.x0 x0Var = null;
        while (true) {
            if (i10 >= iL) {
                break;
            }
            q4.x0 x0VarM = RecyclerView.M(recyclerView.f1672z.k(i10));
            if (x0VarM != null && !x0VarM.h() && x0VarM.f10964c == i) {
                if (!((ArrayList) recyclerView.f1672z.f3840y).contains(x0VarM.f10962a)) {
                    x0Var = x0VarM;
                    break;
                }
                x0Var = x0VarM;
            }
            i10++;
        }
        if (x0Var != null) {
            if (!((ArrayList) recyclerView.f1672z.f3840y).contains(x0Var.f10962a)) {
                return x0Var;
            }
            if (RecyclerView.W0) {
                Log.d("RecyclerView", "assuming view holder cannot be find because it is hidden");
            }
        }
        return null;
    }

    public void w(int i, int i10, Object obj) {
        int i11;
        int i12;
        RecyclerView recyclerView = (RecyclerView) this.f8343u;
        int iL = recyclerView.f1672z.l();
        int i13 = i10 + i;
        for (int i14 = 0; i14 < iL; i14++) {
            View viewK = recyclerView.f1672z.k(i14);
            q4.x0 x0VarM = RecyclerView.M(viewK);
            if (x0VarM != null && !x0VarM.o() && (i12 = x0VarM.f10964c) >= i && i12 < i13) {
                x0VarM.a(2);
                if (obj == null) {
                    x0VarM.a(1024);
                } else if ((1024 & x0VarM.f10969j) == 0) {
                    if (x0VarM.f10970k == null) {
                        ArrayList arrayList = new ArrayList();
                        x0VarM.f10970k = arrayList;
                        x0VarM.f10971l = Collections.unmodifiableList(arrayList);
                    }
                    x0VarM.f10970k.add(obj);
                }
                ((q4.i0) viewK.getLayoutParams()).f10833c = true;
            }
        }
        q4.n0 n0Var = recyclerView.f1666w;
        ArrayList arrayList2 = n0Var.f10883c;
        for (int size = arrayList2.size() - 1; size >= 0; size--) {
            q4.x0 x0Var = (q4.x0) arrayList2.get(size);
            if (x0Var != null && (i11 = x0Var.f10964c) >= i && i11 < i13) {
                x0Var.a(2);
                n0Var.g(size);
            }
        }
        recyclerView.E0 = true;
    }

    public void y(int i, int i10) {
        RecyclerView recyclerView = (RecyclerView) this.f8343u;
        int iL = recyclerView.f1672z.l();
        for (int i11 = 0; i11 < iL; i11++) {
            q4.x0 x0VarM = RecyclerView.M(recyclerView.f1672z.k(i11));
            if (x0VarM != null && !x0VarM.o() && x0VarM.f10964c >= i) {
                if (RecyclerView.W0) {
                    Log.d("RecyclerView", "offsetPositionRecordsForInsert attached child " + i11 + " holder " + x0VarM + " now at position " + (x0VarM.f10964c + i10));
                }
                x0VarM.l(i10, false);
                recyclerView.A0.f = true;
            }
        }
        ArrayList arrayList = recyclerView.f1666w.f10883c;
        int size = arrayList.size();
        for (int i12 = 0; i12 < size; i12++) {
            q4.x0 x0Var = (q4.x0) arrayList.get(i12);
            if (x0Var != null && x0Var.f10964c >= i) {
                if (RecyclerView.W0) {
                    Log.d("RecyclerView", "offsetPositionRecordsForInsert cached " + i12 + " holder " + x0Var + " now at position " + (x0Var.f10964c + i10));
                }
                x0Var.l(i10, false);
            }
        }
        recyclerView.requestLayout();
        recyclerView.D0 = true;
    }

    public void z(int i, int i10) {
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        RecyclerView recyclerView = (RecyclerView) this.f8343u;
        int iL = recyclerView.f1672z.l();
        if (i < i10) {
            i12 = i;
            i11 = i10;
            i13 = -1;
        } else {
            i11 = i;
            i12 = i10;
            i13 = 1;
        }
        boolean z2 = false;
        for (int i19 = 0; i19 < iL; i19++) {
            q4.x0 x0VarM = RecyclerView.M(recyclerView.f1672z.k(i19));
            if (x0VarM != null && (i18 = x0VarM.f10964c) >= i12 && i18 <= i11) {
                if (RecyclerView.W0) {
                    Log.d("RecyclerView", "offsetPositionRecordsForMove attached child " + i19 + " holder " + x0VarM);
                }
                if (x0VarM.f10964c == i) {
                    x0VarM.l(i10 - i, false);
                } else {
                    x0VarM.l(i13, false);
                }
                recyclerView.A0.f = true;
            }
        }
        ArrayList arrayList = recyclerView.f1666w.f10883c;
        if (i < i10) {
            i15 = i;
            i14 = i10;
            i16 = -1;
        } else {
            i14 = i;
            i15 = i10;
            i16 = 1;
        }
        int size = arrayList.size();
        int i20 = 0;
        while (i20 < size) {
            q4.x0 x0Var = (q4.x0) arrayList.get(i20);
            if (x0Var != null && (i17 = x0Var.f10964c) >= i15 && i17 <= i14) {
                if (i17 == i) {
                    x0Var.l(i10 - i, z2);
                } else {
                    x0Var.l(i16, z2);
                }
                if (RecyclerView.W0) {
                    Log.d("RecyclerView", "offsetPositionRecordsForMove cached child " + i20 + " holder " + x0Var);
                }
            }
            i20++;
            z2 = false;
        }
        recyclerView.requestLayout();
        recyclerView.D0 = true;
    }

    public a1(Context context, GestureDetector.SimpleOnGestureListener simpleOnGestureListener) {
        this.f8343u = new GestureDetector(context, simpleOnGestureListener, null);
    }

    @Override // n.z0
    public void a(int i) {
    }

    @Override // u2.d0
    public void b(p1.r1 r1Var) {
    }

    @Override // n.z0
    public void j(int i) {
    }

    @Override // n.z0
    public void n(int i, float f) {
    }

    @Override // s2.h
    public /* synthetic */ void k(s2.j jVar, long j5, long j8, int i) {
    }

    @Override // s2.h
    public void u(s2.j jVar, long j5, long j8, boolean z2) {
    }
}
