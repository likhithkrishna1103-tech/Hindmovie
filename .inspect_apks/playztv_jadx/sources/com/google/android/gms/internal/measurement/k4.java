package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.os.Trace;
import android.text.Spannable;
import android.text.SpannableString;
import android.util.Log;
import android.view.Surface;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class k4 implements j4, androidx.emoji2.text.q, o8.g, t3.m, ne.b, w2.j, j2.l, e7.b, q0.p, s2.o, l6.n, pc.l, o8.a {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static k4 f3069w;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Object f3070u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Object f3071v;

    public /* synthetic */ k4(Object obj) {
        this.f3070u = obj;
        this.f3071v = null;
    }

    public static synchronized void D() {
        Context context;
        try {
            k4 k4Var = f3069w;
            if (k4Var != null && (context = (Context) k4Var.f3070u) != null && ((l4) k4Var.f3071v) != null) {
                context.getContentResolver().unregisterContentObserver((l4) f3069w.f3071v);
            }
            f3069w = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0044 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x003f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.gms.internal.measurement.k4 l(android.content.Context r5) {
        /*
            java.lang.String r0 = "generatefid.lock"
            r1 = 0
            java.io.File r2 = new java.io.File     // Catch: java.nio.channels.OverlappingFileLockException -> L2e java.lang.Error -> L32 java.io.IOException -> L34
            java.io.File r5 = r5.getFilesDir()     // Catch: java.nio.channels.OverlappingFileLockException -> L2e java.lang.Error -> L32 java.io.IOException -> L34
            r2.<init>(r5, r0)     // Catch: java.nio.channels.OverlappingFileLockException -> L2e java.lang.Error -> L32 java.io.IOException -> L34
            java.io.RandomAccessFile r5 = new java.io.RandomAccessFile     // Catch: java.nio.channels.OverlappingFileLockException -> L2e java.lang.Error -> L32 java.io.IOException -> L34
            java.lang.String r0 = "rw"
            r5.<init>(r2, r0)     // Catch: java.nio.channels.OverlappingFileLockException -> L2e java.lang.Error -> L32 java.io.IOException -> L34
            java.nio.channels.FileChannel r5 = r5.getChannel()     // Catch: java.nio.channels.OverlappingFileLockException -> L2e java.lang.Error -> L32 java.io.IOException -> L34
            java.nio.channels.FileLock r0 = r5.lock()     // Catch: java.nio.channels.OverlappingFileLockException -> L27 java.lang.Error -> L2a java.io.IOException -> L2c
            com.google.android.gms.internal.measurement.k4 r2 = new com.google.android.gms.internal.measurement.k4     // Catch: java.nio.channels.OverlappingFileLockException -> L21 java.lang.Error -> L23 java.io.IOException -> L25
            r2.<init>(r5, r0)     // Catch: java.nio.channels.OverlappingFileLockException -> L21 java.lang.Error -> L23 java.io.IOException -> L25
            return r2
        L21:
            r2 = move-exception
            goto L36
        L23:
            r2 = move-exception
            goto L36
        L25:
            r2 = move-exception
            goto L36
        L27:
            r2 = move-exception
        L28:
            r0 = r1
            goto L36
        L2a:
            r2 = move-exception
            goto L28
        L2c:
            r2 = move-exception
            goto L28
        L2e:
            r2 = move-exception
        L2f:
            r5 = r1
            r0 = r5
            goto L36
        L32:
            r2 = move-exception
            goto L2f
        L34:
            r2 = move-exception
            goto L2f
        L36:
            java.lang.String r3 = "CrossProcessLock"
            java.lang.String r4 = "encountered error while creating and acquiring the lock, ignoring"
            android.util.Log.e(r3, r4, r2)
            if (r0 == 0) goto L42
            r0.release()     // Catch: java.io.IOException -> L42
        L42:
            if (r5 == 0) goto L47
            r5.close()     // Catch: java.io.IOException -> L47
        L47:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.k4.l(android.content.Context):com.google.android.gms.internal.measurement.k4");
    }

    public void A() {
        try {
            ((FileLock) this.f3071v).release();
            ((FileChannel) this.f3070u).close();
        } catch (IOException e10) {
            Log.e("CrossProcessLock", "encountered error while releasing, ignoring", e10);
        }
    }

    public void B(int i) {
        Toolbar toolbar = (Toolbar) this.f3070u;
        if (i == 0) {
            toolbar.setNavigationContentDescription((CharSequence) this.f3071v);
        } else {
            toolbar.setNavigationContentDescription(i);
        }
    }

    @Override // q0.p
    public q0.r1 C(View view, q0.r1 r1Var) {
        k5.i iVar = (k5.i) this.f3071v;
        q0.r1 r1VarI = q0.o0.i(view, r1Var);
        if (r1VarI.f10492a.n()) {
            return r1VarI;
        }
        Rect rect = (Rect) this.f3070u;
        rect.left = r1VarI.b();
        rect.top = r1VarI.d();
        rect.right = r1VarI.c();
        rect.bottom = r1VarI.a();
        int childCount = iVar.getChildCount();
        for (int i = 0; i < childCount; i++) {
            q0.r1 r1VarB = q0.o0.b(iVar.getChildAt(i), r1VarI);
            rect.left = Math.min(r1VarB.b(), rect.left);
            rect.top = Math.min(r1VarB.d(), rect.top);
            rect.right = Math.min(r1VarB.c(), rect.right);
            rect.bottom = Math.min(r1VarB.a(), rect.bottom);
        }
        return r1VarI.f(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void E(ub.o oVar, a7.b bVar) {
        TreeMap treeMap = (TreeMap) this.f3071v;
        r6 r6Var = new r6(bVar);
        TreeMap treeMap2 = (TreeMap) this.f3070u;
        for (Integer num : treeMap2.keySet()) {
            c cVar = (c) ((c) bVar.f619w).clone();
            n nVarA = ((o) treeMap2.get(num)).a(oVar, Collections.singletonList(r6Var));
            int iM = nVarA instanceof g ? c4.m(((g) nVarA).f2977u.doubleValue()) : -1;
            if (iM == 2 || iM == -1) {
                bVar.f619w = cVar;
            }
        }
        Iterator it = treeMap.keySet().iterator();
        while (it.hasNext()) {
            n nVarA2 = ((o) treeMap.get((Integer) it.next())).a(oVar, Collections.singletonList(r6Var));
            if (nVarA2 instanceof g) {
                c4.m(((g) nVarA2).f2977u.doubleValue());
            }
        }
    }

    @Override // androidx.emoji2.text.q
    public Object a() {
        return (androidx.emoji2.text.b0) this.f3070u;
    }

    @Override // o8.a
    public Object b(o8.o oVar) {
        Bundle bundle;
        p7.b bVar = (p7.b) this.f3070u;
        Bundle bundle2 = (Bundle) this.f3071v;
        bVar.getClass();
        return (oVar.j() && (bundle = (Bundle) oVar.h()) != null && bundle.containsKey("google.messenger")) ? bVar.a(bundle2).k(p7.h.f10264w, p7.d.f10259x) : oVar;
    }

    @Override // l6.n
    public void c(Bitmap bitmap, f6.a aVar) throws IOException {
        IOException iOException = ((x6.e) this.f3071v).f14279v;
        if (iOException != null) {
            if (bitmap == null) {
                throw iOException;
            }
            aVar.f(bitmap);
            throw iOException;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0055, code lost:
    
        r3 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0064 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.google.android.gms.internal.measurement.j4
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object d(java.lang.String r10) {
        /*
            r9 = this;
            java.lang.Object r0 = r9.f3070u
            android.content.Context r0 = (android.content.Context) r0
            r1 = 0
            if (r0 == 0) goto La1
            boolean r2 = com.google.android.gms.internal.measurement.e4.a()
            if (r2 == 0) goto L64
            boolean r2 = com.google.android.gms.internal.measurement.e4.f2954b
            r3 = 1
            if (r2 == 0) goto L13
            goto L5f
        L13:
            java.lang.Class<com.google.android.gms.internal.measurement.e4> r2 = com.google.android.gms.internal.measurement.e4.class
            monitor-enter(r2)
            boolean r4 = com.google.android.gms.internal.measurement.e4.f2954b     // Catch: java.lang.Throwable -> L1c
            if (r4 == 0) goto L1e
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L1c
            goto L5f
        L1c:
            r10 = move-exception
            goto L62
        L1e:
            r4 = r3
        L1f:
            r5 = 2
            r6 = 0
            r7 = 0
            if (r4 > r5) goto L55
            android.os.UserManager r5 = com.google.android.gms.internal.measurement.e4.f2953a     // Catch: java.lang.Throwable -> L1c
            if (r5 != 0) goto L32
            java.lang.Class<android.os.UserManager> r5 = android.os.UserManager.class
            java.lang.Object r5 = r0.getSystemService(r5)     // Catch: java.lang.Throwable -> L1c
            android.os.UserManager r5 = (android.os.UserManager) r5     // Catch: java.lang.Throwable -> L1c
            com.google.android.gms.internal.measurement.e4.f2953a = r5     // Catch: java.lang.Throwable -> L1c
        L32:
            android.os.UserManager r5 = com.google.android.gms.internal.measurement.e4.f2953a     // Catch: java.lang.Throwable -> L1c
            if (r5 != 0) goto L37
            goto L5a
        L37:
            boolean r8 = aa.c0.z(r5)     // Catch: java.lang.Throwable -> L1c java.lang.NullPointerException -> L48
            if (r8 != 0) goto L56
            android.os.UserHandle r8 = android.os.Process.myUserHandle()     // Catch: java.lang.Throwable -> L1c java.lang.NullPointerException -> L48
            boolean r0 = r5.isUserRunning(r8)     // Catch: java.lang.Throwable -> L1c java.lang.NullPointerException -> L48
            if (r0 != 0) goto L55
            goto L56
        L48:
            r5 = move-exception
            java.lang.String r7 = "DirectBootUtils"
            java.lang.String r8 = "Failed to check if user is unlocked."
            android.util.Log.w(r7, r8, r5)     // Catch: java.lang.Throwable -> L1c
            com.google.android.gms.internal.measurement.e4.f2953a = r6     // Catch: java.lang.Throwable -> L1c
            int r4 = r4 + 1
            goto L1f
        L55:
            r3 = r7
        L56:
            if (r3 == 0) goto L5a
            com.google.android.gms.internal.measurement.e4.f2953a = r6     // Catch: java.lang.Throwable -> L1c
        L5a:
            if (r3 == 0) goto L5e
            com.google.android.gms.internal.measurement.e4.f2954b = r3     // Catch: java.lang.Throwable -> L1c
        L5e:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L1c
        L5f:
            if (r3 != 0) goto L64
            goto La1
        L62:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L1c
            throw r10
        L64:
            h4.z r0 = new h4.z     // Catch: java.lang.NullPointerException -> L83 java.lang.SecurityException -> L85 java.lang.IllegalStateException -> L87
            r2 = 10
            r3 = 0
            r0.<init>(r2, r3)     // Catch: java.lang.NullPointerException -> L83 java.lang.SecurityException -> L85 java.lang.IllegalStateException -> L87
            r0.f5867v = r9     // Catch: java.lang.NullPointerException -> L83 java.lang.SecurityException -> L85 java.lang.IllegalStateException -> L87
            r0.f5868w = r10     // Catch: java.lang.NullPointerException -> L83 java.lang.SecurityException -> L85 java.lang.IllegalStateException -> L87
            java.lang.Object r0 = r0.m0()     // Catch: java.lang.SecurityException -> L75 java.lang.NullPointerException -> L83 java.lang.IllegalStateException -> L87
            goto L80
        L75:
            long r2 = android.os.Binder.clearCallingIdentity()     // Catch: java.lang.NullPointerException -> L83 java.lang.SecurityException -> L85 java.lang.IllegalStateException -> L87
            java.lang.Object r0 = r0.m0()     // Catch: java.lang.Throwable -> L89
            android.os.Binder.restoreCallingIdentity(r2)     // Catch: java.lang.NullPointerException -> L83 java.lang.SecurityException -> L85 java.lang.IllegalStateException -> L87
        L80:
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.NullPointerException -> L83 java.lang.SecurityException -> L85 java.lang.IllegalStateException -> L87
            return r0
        L83:
            r0 = move-exception
            goto L8e
        L85:
            r0 = move-exception
            goto L8e
        L87:
            r0 = move-exception
            goto L8e
        L89:
            r0 = move-exception
            android.os.Binder.restoreCallingIdentity(r2)     // Catch: java.lang.NullPointerException -> L83 java.lang.SecurityException -> L85 java.lang.IllegalStateException -> L87
            throw r0     // Catch: java.lang.NullPointerException -> L83 java.lang.SecurityException -> L85 java.lang.IllegalStateException -> L87
        L8e:
            java.lang.String r2 = "GservicesLoader"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Unable to read GServices for: "
            r3.<init>(r4)
            r3.append(r10)
            java.lang.String r10 = r3.toString()
            android.util.Log.e(r2, r10, r0)
        La1:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.k4.d(java.lang.String):java.lang.Object");
    }

    @Override // s2.o
    public Object e(Uri uri, v1.k kVar) {
        l2.a aVar = (l2.a) ((s2.o) this.f3070u).e(uri, kVar);
        List list = (List) this.f3071v;
        return (list == null || list.isEmpty()) ? aVar : (l2.a) aVar.a(list);
    }

    @Override // pc.l
    public void f(String str, boolean z2) {
        nc.m mVar = (nc.m) this.f3071v;
        if (mVar.f8948x0.equals((String) this.f3070u)) {
            if (!z2) {
                ((SwipeRefreshLayout) mVar.f8944t0.f1740e).setRefreshing(false);
                ((RecyclerView) mVar.f8944t0.f1739d).setVisibility(8);
                ((TextView) mVar.f8944t0.f1738c).setVisibility(0);
            } else {
                if (mVar.f8950z0.equals("m3u")) {
                    mVar.X(str);
                    return;
                }
                try {
                    nc.m.T(mVar, new JSONArray(str));
                } catch (JSONException e10) {
                    Log.e("Pro JSONException", e10.getMessage());
                    ((SwipeRefreshLayout) mVar.f8944t0.f1740e).setRefreshing(false);
                    ((RecyclerView) mVar.f8944t0.f1739d).setVisibility(8);
                    ((TextView) mVar.f8944t0.f1738c).setVisibility(0);
                }
            }
        }
    }

    @Override // androidx.emoji2.text.q
    public boolean g(CharSequence charSequence, int i, int i10, androidx.emoji2.text.y yVar) {
        if ((yVar.f1214c & 4) > 0) {
            return true;
        }
        if (((androidx.emoji2.text.b0) this.f3070u) == null) {
            this.f3070u = new androidx.emoji2.text.b0(charSequence instanceof Spannable ? (Spannable) charSequence : new SpannableString(charSequence));
        }
        ((t7.j) this.f3071v).getClass();
        ((androidx.emoji2.text.b0) this.f3070u).setSpan(new androidx.emoji2.text.z(yVar), i, i10, 33);
        return true;
    }

    @Override // md.a
    public Object get() {
        int i = 17;
        k8.b0 b0Var = new k8.b0(i);
        k8.a0 a0Var = new k8.a0(i);
        Object obj = ((md.a) this.f3070u).get();
        md.a aVar = (md.a) this.f3071v;
        return new j7.g(b0Var, a0Var, j7.a.f, (j7.i) obj, aVar);
    }

    @Override // t3.m
    public /* synthetic */ t3.d h(byte[] bArr, int i, int i10) {
        return e6.j.a(this, bArr, i10);
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x011c A[EDGE_INSN: B:68:0x011c->B:52:0x011c BREAK  A[LOOP:1: B:38:0x00e3->B:51:0x010b], SYNTHETIC] */
    @Override // w2.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public w2.i i(w2.p r17, long r18) {
        /*
            Method dump skipped, instruction units count: 305
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.k4.i(w2.p, long):w2.i");
    }

    @Override // w2.j
    public void k() {
        s1.u uVar = (s1.u) this.f3071v;
        byte[] bArr = s1.b0.f11649c;
        uVar.getClass();
        uVar.H(bArr.length, bArr);
    }

    @Override // t3.m
    public int m() {
        return 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:130:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0369  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x036e  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0373  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0386  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0363 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ae  */
    /* JADX WARN: Type inference failed for: r14v6 */
    /* JADX WARN: Type inference failed for: r14v7, types: [boolean] */
    /* JADX WARN: Type inference failed for: r14v8 */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v2 */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r4v49 */
    /* JADX WARN: Type inference failed for: r4v50 */
    /* JADX WARN: Type inference failed for: r4v51 */
    /* JADX WARN: Type inference failed for: r8v22 */
    /* JADX WARN: Type inference failed for: r8v23 */
    /* JADX WARN: Type inference failed for: r8v25 */
    /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
        java.lang.UnsupportedOperationException
        	at java.base/java.util.Collections$UnmodifiableCollection.add(Collections.java:1092)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:390)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:23)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaksForCase(SwitchRegionMaker.java:370)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaks(SwitchRegionMaker.java:85)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.leaveRegion(PostProcessRegions.java:33)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:23)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    @Override // t3.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void n(byte[] r19, int r20, int r21, t3.l r22, s1.h r23) {
        /*
            Method dump skipped, instruction units count: 1062
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.k4.n(byte[], int, int, t3.l, s1.h):void");
    }

    @Override // ne.b
    public Object o(ne.c cVar, td.c cVar2) throws Throwable {
        Object objO = ((h4.z) this.f3070u).o(new cc.c0(cVar, (cc.f0) this.f3071v), cVar2);
        return objO == sd.a.f11942u ? objO : nd.k.f8990a;
    }

    @Override // j2.l
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public j2.d j(b2.g gVar) throws Exception {
        MediaCodec mediaCodecCreateByCodecName;
        String str = ((j2.p) gVar.f1737b).f6710a;
        j2.d dVar = null;
        try {
            Trace.beginSection("createCodec:" + str);
            mediaCodecCreateByCodecName = MediaCodec.createByCodecName(str);
            try {
                j2.d dVar2 = new j2.d(mediaCodecCreateByCodecName, (HandlerThread) ((j2.c) this.f3070u).get(), new j2.g(mediaCodecCreateByCodecName, (HandlerThread) ((j2.c) this.f3071v).get()), (a7.b) gVar.f1741g);
                try {
                    Trace.endSection();
                    Surface surface = (Surface) gVar.f1740e;
                    j2.d.c(dVar2, (MediaFormat) gVar.f1738c, surface, (MediaCrypto) gVar.f, (surface == null && ((j2.p) gVar.f1737b).f6716h && Build.VERSION.SDK_INT >= 35) ? 8 : 0);
                    return dVar2;
                } catch (Exception e10) {
                    e = e10;
                    dVar = dVar2;
                    if (dVar != null) {
                        dVar.release();
                    } else if (mediaCodecCreateByCodecName != null) {
                        mediaCodecCreateByCodecName.release();
                    }
                    throw e;
                }
            } catch (Exception e11) {
                e = e11;
            }
        } catch (Exception e12) {
            e = e12;
            mediaCodecCreateByCodecName = null;
        }
    }

    public void q(a2.h hVar) {
        synchronized (hVar) {
        }
        Handler handler = (Handler) this.f3070u;
        if (handler != null) {
            handler.post(new a2.g0(this, 10, hVar));
        }
    }

    @Override // o8.g
    public o8.o r(Object obj) throws Throwable {
        FileWriter fileWriter;
        b7.s sVar = (b7.s) this.f3071v;
        JSONObject jSONObject = (JSONObject) ((ua.d) this.f3070u).f12825c.f12820u.submit(new bb.d(0, this)).get();
        FileWriter fileWriter2 = null;
        if (jSONObject != null) {
            bb.c cVarQ = ((u5.d) sVar.f1900c).Q(jSONObject);
            rc.b bVar = (rc.b) sVar.f1902e;
            long j5 = cVarQ.f1982c;
            bVar.getClass();
            if (Log.isLoggable("FirebaseCrashlytics", 2)) {
                Log.v("FirebaseCrashlytics", "Writing settings to cache file...", null);
            }
            try {
                jSONObject.put("expires_at", j5);
                fileWriter = new FileWriter((File) bVar.f11562v);
                try {
                    try {
                        fileWriter.write(jSONObject.toString());
                        fileWriter.flush();
                    } catch (Throwable th) {
                        th = th;
                        fileWriter2 = fileWriter;
                        ta.f.b(fileWriter2, "Failed to close settings writer.");
                        throw th;
                    }
                } catch (Exception e10) {
                    e = e10;
                    Log.e("FirebaseCrashlytics", "Failed to cache settings", e);
                }
            } catch (Exception e11) {
                e = e11;
                fileWriter = null;
            } catch (Throwable th2) {
                th = th2;
                ta.f.b(fileWriter2, "Failed to close settings writer.");
                throw th;
            }
            ta.f.b(fileWriter, "Failed to close settings writer.");
            b7.s.f(jSONObject, "Loaded settings: ");
            String str = ((bb.f) sVar.f1899b).f;
            SharedPreferences.Editor editorEdit = ((Context) sVar.f1898a).getSharedPreferences("com.google.firebase.crashlytics", 0).edit();
            editorEdit.putString("existing_instance_identifier", str);
            editorEdit.apply();
            ((AtomicReference) sVar.f1904h).set(cVarQ);
            ((o8.h) ((AtomicReference) sVar.i).get()).c(cVarQ);
        }
        return wa.t1.k(null);
    }

    @Override // l6.n
    public void s() {
        l6.v vVar = (l6.v) this.f3070u;
        synchronized (vVar) {
            vVar.f8010w = vVar.f8008u.length;
        }
    }

    public byte[] t(h3.a aVar) {
        DataOutputStream dataOutputStream = (DataOutputStream) this.f3071v;
        ByteArrayOutputStream byteArrayOutputStream = (ByteArrayOutputStream) this.f3070u;
        byteArrayOutputStream.reset();
        try {
            dataOutputStream.writeBytes(aVar.f5783a);
            dataOutputStream.writeByte(0);
            dataOutputStream.writeBytes(aVar.f5784b);
            dataOutputStream.writeByte(0);
            dataOutputStream.writeLong(aVar.f5785c);
            dataOutputStream.writeLong(aVar.f5786d);
            dataOutputStream.write(aVar.f5787e);
            dataOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e10) {
            throw new RuntimeException(e10);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.google.android.datatransport.cct.CctBackendFactory u(java.lang.String r14) {
        /*
            Method dump skipped, instruction units count: 273
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.k4.u(java.lang.String):com.google.android.datatransport.cct.CctBackendFactory");
    }

    public void v(Exception exc, boolean z2) {
        this.f3071v = null;
        HashSet hashSet = (HashSet) this.f3070u;
        aa.j0 j0VarR = aa.j0.r(hashSet);
        hashSet.clear();
        aa.h0 h0VarListIterator = j0VarR.listIterator(0);
        while (h0VarListIterator.hasNext()) {
            f2.c cVar = (f2.c) h0VarListIterator.next();
            cVar.getClass();
            cVar.k(exc, z2 ? 1 : 3);
        }
    }

    public void w(n0.g gVar) {
        c7.r rVar = (c7.r) this.f3071v;
        wb.c cVar = (wb.c) this.f3070u;
        int i = gVar.f8624b;
        if (i != 0) {
            rVar.execute(new androidx.emoji2.text.k(i, 3, cVar));
        } else {
            rVar.execute(new ea.t(cVar, 20, gVar.f8623a));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:144:0x0205, code lost:
    
        continue;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:112:0x010c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0105 A[Catch: IOException -> 0x008d, XmlPullParserException -> 0x0090, TryCatch #2 {IOException -> 0x008d, XmlPullParserException -> 0x0090, blocks: (B:19:0x005e, B:96:0x0205, B:27:0x0070, B:28:0x007e, B:30:0x0083, B:37:0x0093, B:45:0x00ad, B:40:0x009c, B:43:0x00a5, B:46:0x00bb, B:50:0x00ca, B:52:0x00d2, B:53:0x00dc, B:62:0x0105, B:63:0x010c, B:64:0x0124, B:56:0x00e5, B:58:0x00ed, B:59:0x00fb, B:65:0x0125, B:67:0x012d, B:68:0x013b, B:71:0x0145, B:72:0x0150, B:73:0x0168, B:74:0x0169, B:77:0x0173, B:78:0x017e, B:79:0x0196, B:80:0x0197, B:82:0x019f, B:83:0x01a8, B:86:0x01b2, B:87:0x01bc, B:88:0x01d4, B:89:0x01d5, B:92:0x01df, B:93:0x01e9, B:94:0x0201, B:95:0x0202), top: B:104:0x005e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void x(android.content.Context r10, android.content.res.XmlResourceParser r11) {
        /*
            Method dump skipped, instruction units count: 604
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.k4.x(android.content.Context, android.content.res.XmlResourceParser):void");
    }

    public void y(f2.c cVar) {
        ((HashSet) this.f3070u).add(cVar);
        if (((f2.c) this.f3071v) != null) {
            return;
        }
        this.f3071v = cVar;
        f2.t tVarF = cVar.f4702b.f();
        cVar.f4722x = tVarF;
        f2.a aVar = cVar.f4716r;
        int i = s1.b0.f11647a;
        tVarF.getClass();
        aVar.getClass();
        aVar.obtainMessage(1, new f2.b(o2.u.f9216b.getAndIncrement(), true, SystemClock.elapsedRealtime(), tVarF)).sendToTarget();
    }

    public void z(String str) {
        g6.b bVar;
        synchronized (this) {
            try {
                Object obj = ((HashMap) this.f3070u).get(str);
                x6.f.c(obj, "Argument must not be null");
                bVar = (g6.b) obj;
                int i = bVar.f5320b;
                if (i < 1) {
                    throw new IllegalStateException("Cannot release a lock that is not held, safeKey: " + str + ", interestedThreads: " + bVar.f5320b);
                }
                int i10 = i - 1;
                bVar.f5320b = i10;
                if (i10 == 0) {
                    g6.b bVar2 = (g6.b) ((HashMap) this.f3070u).remove(str);
                    if (!bVar2.equals(bVar)) {
                        throw new IllegalStateException("Removed the wrong lock, expected to remove: " + bVar + ", but actually removed: " + bVar2 + ", safeKey: " + str);
                    }
                    ((g6.c) this.f3071v).b(bVar2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        bVar.f5319a.unlock();
    }

    public /* synthetic */ k4(Object obj, Object obj2) {
        this.f3070u = obj;
        this.f3071v = obj2;
    }

    public /* synthetic */ k4(Object obj, Object obj2, boolean z2) {
        this.f3071v = obj;
        this.f3070u = obj2;
    }

    public k4(int i) {
        switch (i) {
            case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                this.f3070u = new s1.u();
                this.f3071v = new c4.a();
                break;
            case 8:
                this.f3070u = new TreeMap();
                this.f3071v = new TreeMap();
                break;
            case 11:
                this.f3070u = new HashSet();
                break;
            case 13:
                this.f3070u = new HashMap();
                this.f3071v = new g6.c(0);
                break;
            case 16:
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
                this.f3070u = byteArrayOutputStream;
                this.f3071v = new DataOutputStream(byteArrayOutputStream);
                break;
            default:
                this.f3070u = null;
                this.f3071v = null;
                break;
        }
    }

    public k4(Handler handler, c2.j jVar) {
        if (jVar != null) {
            handler.getClass();
        } else {
            handler = null;
        }
        this.f3070u = handler;
        this.f3071v = jVar;
    }

    @Override // t3.m
    public /* synthetic */ void reset() {
    }
}
