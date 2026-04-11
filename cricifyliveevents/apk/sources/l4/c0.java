package l4;

import android.animation.Animator;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaCodec;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.ActionMode;
import android.view.Menu;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.r0;
import app.cricfy.tv.activities.PlayerActivity;
import f9.b4;
import f9.f1;
import f9.f4;
import f9.l2;
import f9.r1;
import f9.w0;
import f9.x2;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import t0.m0;
import t0.q0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c0 implements androidx.emoji2.text.s, b2.g, t0.o, z7.b, ya.r, x3.p, x6.k, g7.o, a3.j, h4.b0 {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f7704v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Object f7705w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Object f7706x;

    public /* synthetic */ c0(int i, Object obj, Object obj2) {
        this.f7704v = i;
        this.f7705w = obj;
        this.f7706x = obj2;
    }

    public static void K(Bundle bundle) {
        if (bundle != null) {
            ClassLoader classLoader = c0.class.getClassLoader();
            classLoader.getClass();
            bundle.setClassLoader(classLoader);
        }
    }

    public void A(boolean z10) {
        r0 r0Var = (r0) this.f7706x;
        h.j jVar = r0Var.f1062u.f952x;
        androidx.fragment.app.y yVar = r0Var.f1064w;
        if (yVar != null) {
            yVar.l().f1054m.A(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f7705w).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z10) {
                throw null;
            }
            throw null;
        }
    }

    public void B(boolean z10) {
        androidx.fragment.app.y yVar = ((r0) this.f7706x).f1064w;
        if (yVar != null) {
            yVar.l().f1054m.B(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f7705w).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z10) {
                throw null;
            }
            throw null;
        }
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
    @Override // x3.p
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void C(byte[] r19, int r20, int r21, x3.o r22, y1.h r23) {
        /*
            Method dump skipped, instruction units count: 1062
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: l4.c0.C(byte[], int, int, x3.o, y1.h):void");
    }

    @Override // x3.p
    public int D() {
        return 1;
    }

    public void E(boolean z10) {
        androidx.fragment.app.y yVar = ((r0) this.f7706x).f1064w;
        if (yVar != null) {
            yVar.l().f1054m.E(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f7705w).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z10) {
                throw null;
            }
            throw null;
        }
    }

    public void F(boolean z10) {
        androidx.fragment.app.y yVar = ((r0) this.f7706x).f1064w;
        if (yVar != null) {
            yVar.l().f1054m.F(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f7705w).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z10) {
                throw null;
            }
            throw null;
        }
    }

    public void G(boolean z10) {
        androidx.fragment.app.y yVar = ((r0) this.f7706x).f1064w;
        if (yVar != null) {
            yVar.l().f1054m.G(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f7705w).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z10) {
                throw null;
            }
            throw null;
        }
    }

    public void H(boolean z10) {
        androidx.fragment.app.y yVar = ((r0) this.f7706x).f1064w;
        if (yVar != null) {
            yVar.l().f1054m.H(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f7705w).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z10) {
                throw null;
            }
            throw null;
        }
    }

    public void I(boolean z10) {
        androidx.fragment.app.y yVar = ((r0) this.f7706x).f1064w;
        if (yVar != null) {
            yVar.l().f1054m.I(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f7705w).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z10) {
                throw null;
            }
            throw null;
        }
    }

    public void J(boolean z10) {
        androidx.fragment.app.y yVar = ((r0) this.f7706x).f1064w;
        if (yVar != null) {
            yVar.l().f1054m.J(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f7705w).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z10) {
                throw null;
            }
            throw null;
        }
    }

    public Object L(a7.j jVar) {
        HashMap map = (HashMap) this.f7706x;
        a7.d dVar = (a7.d) map.get(jVar);
        if (dVar == null) {
            dVar = new a7.d(jVar);
            map.put(jVar, dVar);
        } else {
            jVar.a();
        }
        a7.d dVar2 = dVar.f312d;
        dVar2.f311c = dVar.f311c;
        dVar.f311c.f312d = dVar2;
        a7.d dVar3 = (a7.d) this.f7705w;
        dVar.f312d = dVar3;
        a7.d dVar4 = dVar3.f311c;
        dVar.f311c = dVar4;
        dVar4.f312d = dVar;
        dVar.f312d.f311c = dVar;
        ArrayList arrayList = dVar.f310b;
        int size = arrayList != null ? arrayList.size() : 0;
        if (size > 0) {
            return dVar.f310b.remove(size - 1);
        }
        return null;
    }

    public a3.p M(Object... objArr) {
        Constructor constructorC;
        synchronized (((AtomicBoolean) this.f7706x)) {
            if (!((AtomicBoolean) this.f7706x).get()) {
                try {
                    constructorC = ((a3.m) this.f7705w).c();
                } catch (ClassNotFoundException unused) {
                    ((AtomicBoolean) this.f7706x).set(true);
                    constructorC = null;
                } catch (Exception e9) {
                    throw new RuntimeException("Error instantiating extension", e9);
                }
            }
            constructorC = null;
        }
        if (constructorC == null) {
            return null;
        }
        try {
            return (a3.p) constructorC.newInstance(objArr);
        } catch (Exception e10) {
            throw new IllegalStateException("Unexpected error creating extractor", e10);
        }
    }

    public String N(x6.e eVar) {
        String strP;
        synchronized (((i2.c0) this.f7705w)) {
            strP = (String) ((i2.c0) this.f7705w).a(eVar);
        }
        if (strP == null) {
            strP = p(eVar);
        }
        synchronized (((i2.c0) this.f7705w)) {
            ((i2.c0) this.f7705w).d(eVar, strP);
        }
        return strP;
    }

    public synchronized Map O() {
        try {
            if (((Map) this.f7706x) == null) {
                this.f7706x = Collections.unmodifiableMap(new HashMap((HashMap) this.f7705w));
            }
        } catch (Throwable th) {
            throw th;
        }
        return (Map) this.f7706x;
    }

    public void P(m.a aVar) {
        nc.p pVar = (nc.p) this.f7705w;
        ((ActionMode.Callback) pVar.f9069a).onDestroyActionMode(pVar.l(aVar));
        h.a0 a0Var = (h.a0) this.f7706x;
        if (a0Var.R != null) {
            a0Var.G.getDecorView().removeCallbacks(a0Var.S);
        }
        if (a0Var.Q != null) {
            q0 q0Var = a0Var.T;
            if (q0Var != null) {
                q0Var.b();
            }
            q0 q0VarA = m0.a(a0Var.Q);
            q0VarA.a(0.0f);
            a0Var.T = q0VarA;
            q0VarA.d(new h.s(2, this));
        }
        a0Var.P = null;
        ViewGroup viewGroup = a0Var.V;
        WeakHashMap weakHashMap = m0.f11777a;
        t0.b0.c(viewGroup);
        a0Var.L();
    }

    public boolean Q(m.a aVar, Menu menu) {
        ViewGroup viewGroup = ((h.a0) this.f7706x).V;
        WeakHashMap weakHashMap = m0.f11777a;
        t0.b0.c(viewGroup);
        nc.p pVar = (nc.p) this.f7705w;
        ActionMode.Callback callback = (ActionMode.Callback) pVar.f9069a;
        m.e eVarL = pVar.l(aVar);
        v.k kVar = (v.k) pVar.f9072d;
        Menu zVar = (Menu) kVar.get(menu);
        if (zVar == null) {
            zVar = new n.z((Context) pVar.f9070b, (n.k) menu);
            kVar.put(menu, zVar);
        }
        return callback.onPrepareActionMode(eVarL, zVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:145:0x0209, code lost:
    
        continue;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0110 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0109 A[Catch: IOException -> 0x0091, XmlPullParserException -> 0x0094, TryCatch #2 {IOException -> 0x0091, XmlPullParserException -> 0x0094, blocks: (B:20:0x0062, B:97:0x0209, B:28:0x0074, B:29:0x0082, B:31:0x0087, B:38:0x0097, B:46:0x00b1, B:41:0x00a0, B:44:0x00a9, B:47:0x00bf, B:51:0x00ce, B:53:0x00d6, B:54:0x00e0, B:63:0x0109, B:64:0x0110, B:65:0x0128, B:57:0x00e9, B:59:0x00f1, B:60:0x00ff, B:66:0x0129, B:68:0x0131, B:69:0x013f, B:72:0x0149, B:73:0x0154, B:74:0x016c, B:75:0x016d, B:78:0x0177, B:79:0x0182, B:80:0x019a, B:81:0x019b, B:83:0x01a3, B:84:0x01ac, B:87:0x01b6, B:88:0x01c0, B:89:0x01d8, B:90:0x01d9, B:93:0x01e3, B:94:0x01ed, B:95:0x0205, B:96:0x0206), top: B:105:0x0062 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void R(android.content.Context r12, android.content.res.XmlResourceParser r13) {
        /*
            Method dump skipped, instruction units count: 608
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: l4.c0.R(android.content.Context, android.content.res.XmlResourceParser):void");
    }

    public void S(a7.j jVar, Object obj) {
        HashMap map = (HashMap) this.f7706x;
        a7.d dVar = (a7.d) map.get(jVar);
        if (dVar == null) {
            dVar = new a7.d(jVar);
            dVar.f312d = dVar;
            a7.d dVar2 = (a7.d) this.f7705w;
            dVar.f312d = dVar2.f312d;
            dVar.f311c = dVar2;
            dVar2.f312d = dVar;
            dVar.f312d.f311c = dVar;
            map.put(jVar, dVar);
        } else {
            jVar.a();
        }
        if (dVar.f310b == null) {
            dVar.f310b = new ArrayList();
        }
        dVar.f310b.add(obj);
    }

    public void T(String str) {
        b7.b bVar;
        synchronized (this) {
            try {
                bVar = (b7.b) ((HashMap) this.f7705w).get(str);
                s7.f.c(bVar, "Argument must not be null");
                int i = bVar.f1823b;
                if (i < 1) {
                    throw new IllegalStateException("Cannot release a lock that is not held, safeKey: " + str + ", interestedThreads: " + bVar.f1823b);
                }
                int i10 = i - 1;
                bVar.f1823b = i10;
                if (i10 == 0) {
                    b7.b bVar2 = (b7.b) ((HashMap) this.f7705w).remove(str);
                    if (!bVar2.equals(bVar)) {
                        throw new IllegalStateException("Removed the wrong lock, expected to remove: " + bVar + ", but actually removed: " + bVar2 + ", safeKey: " + str);
                    }
                    ((b7.c) this.f7706x).b(bVar2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        bVar.f1822a.unlock();
    }

    public void U(int i) {
        synchronized (this.f7705w) {
        }
    }

    public Object V() {
        a7.d dVar = (a7.d) this.f7705w;
        a7.d dVar2 = dVar.f312d;
        while (true) {
            boolean zEquals = dVar2.equals(dVar);
            Object obj = dVar2.f309a;
            if (zEquals) {
                return null;
            }
            ArrayList arrayList = dVar2.f310b;
            int size = arrayList != null ? arrayList.size() : 0;
            Object objRemove = size > 0 ? dVar2.f310b.remove(size - 1) : null;
            if (objRemove != null) {
                return objRemove;
            }
            a7.d dVar3 = dVar2.f312d;
            dVar3.f311c = dVar2.f311c;
            dVar2.f311c.f312d = dVar3;
            ((HashMap) this.f7706x).remove(obj);
            ((a7.j) obj).a();
            dVar2 = dVar2.f312d;
        }
    }

    public void W(int i) {
        Toolbar toolbar = (Toolbar) this.f7705w;
        if (i == 0) {
            toolbar.setNavigationContentDescription((CharSequence) this.f7706x);
        } else {
            toolbar.setNavigationContentDescription(i);
        }
    }

    public void X(u uVar, Handler handler) {
        w wVar = (w) this.f7705w;
        synchronized (wVar.f7768d) {
            wVar.f7774l = uVar;
            wVar.f7765a.setCallback(uVar.f7759b, handler);
            uVar.C(wVar, handler);
        }
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [java.util.AbstractCollection, java.util.List] */
    public void Y(k0 k0Var) {
        w wVar = (w) this.f7705w;
        wVar.f7770g = k0Var;
        synchronized (wVar.f7768d) {
            for (int iBeginBroadcast = wVar.f.beginBroadcast() - 1; iBeginBroadcast >= 0; iBeginBroadcast--) {
                try {
                    ((g) wVar.f.getBroadcastItem(iBeginBroadcast)).J(k0Var);
                } catch (RemoteException | SecurityException e9) {
                    Log.e("MediaSessionCompat", "Dead object in setPlaybackState.", e9);
                }
            }
            wVar.f.finishBroadcast();
        }
        MediaSession mediaSession = wVar.f7765a;
        if (k0Var.G == null) {
            PlaybackState.Builder builder = new PlaybackState.Builder();
            builder.setState(k0Var.f7731v, k0Var.f7732w, k0Var.f7734y, k0Var.C);
            builder.setBufferedPosition(k0Var.f7733x);
            builder.setActions(k0Var.f7735z);
            builder.setErrorMessage(k0Var.B);
            for (j0 j0Var : k0Var.D) {
                j0Var.getClass();
                PlaybackState.CustomAction.Builder builder2 = new PlaybackState.CustomAction.Builder(j0Var.f7726v, j0Var.f7727w, j0Var.f7728x);
                builder2.setExtras(j0Var.f7729y);
                PlaybackState.CustomAction customActionBuild = builder2.build();
                if (customActionBuild != null) {
                    builder.addCustomAction(customActionBuild);
                }
            }
            builder.setActiveQueueItemId(k0Var.E);
            builder.setExtras(k0Var.F);
            k0Var.G = builder.build();
        }
        mediaSession.setPlaybackState(k0Var.G);
    }

    public void Z() {
        r1 r1Var = (r1) ((x2) this.f7706x).f307w;
        f1 f1Var = r1Var.f4367z;
        r1.e(f1Var);
        SparseArray sparseArrayS1 = f1Var.s1();
        f4 f4Var = (f4) this.f7705w;
        sparseArrayS1.put(f4Var.f4182x, Long.valueOf(f4Var.f4181w));
        f1 f1Var2 = r1Var.f4367z;
        r1.e(f1Var2);
        int[] iArr = new int[sparseArrayS1.size()];
        long[] jArr = new long[sparseArrayS1.size()];
        for (int i = 0; i < sparseArrayS1.size(); i++) {
            iArr[i] = sparseArrayS1.keyAt(i);
            jArr[i] = ((Long) sparseArrayS1.valueAt(i)).longValue();
        }
        Bundle bundle = new Bundle();
        bundle.putIntArray("uriSources", iArr);
        bundle.putLongArray("uriTimestamps", jArr);
        f1Var2.J.E(bundle);
    }

    @Override // ya.r
    public void a(Object obj) {
        x2 x2Var = (x2) this.f7706x;
        x2Var.m1();
        Z();
        x2Var.E = false;
        x2Var.F = 1;
        w0 w0Var = ((r1) x2Var.f307w).A;
        r1.g(w0Var);
        w0Var.I.b(((f4) this.f7705w).f4180v, "Successfully registered trigger URI");
        x2Var.L1();
    }

    @Override // h4.b0
    public void b(y1.t tVar) {
        h4.e0 e0Var = (h4.e0) this.f7706x;
        SparseArray sparseArray = e0Var.f5611h;
        a3.k0 k0Var = (a3.k0) this.f7705w;
        if (tVar.x() == 0 && (tVar.x() & 128) != 0) {
            tVar.K(6);
            int iA = tVar.a() / 4;
            for (int i = 0; i < iA; i++) {
                tVar.h(k0Var.f208b, 0, 4);
                k0Var.q(0);
                int i10 = k0Var.i(16);
                k0Var.t(3);
                if (i10 == 0) {
                    k0Var.t(13);
                } else {
                    int i11 = k0Var.i(13);
                    if (sparseArray.get(i11) == null) {
                        sparseArray.put(i11, new h4.c0(new ff.m(e0Var, i11)));
                        e0Var.f5616n++;
                    }
                }
            }
            if (e0Var.f5605a != 2) {
                sparseArray.remove(0);
            }
        }
    }

    @Override // androidx.emoji2.text.s
    public Object d() {
        return (androidx.emoji2.text.f0) this.f7705w;
    }

    @Override // g7.o
    public void e(a7.b bVar, Bitmap bitmap) throws IOException {
        IOException iOException = ((s7.e) this.f7706x).f11595w;
        if (iOException != null) {
            if (bitmap == null) {
                throw iOException;
            }
            bVar.d(bitmap);
            throw iOException;
        }
    }

    @Override // androidx.emoji2.text.s
    public boolean f(CharSequence charSequence, int i, int i10, androidx.emoji2.text.c0 c0Var) {
        if ((c0Var.f842c & 4) > 0) {
            return true;
        }
        if (((androidx.emoji2.text.f0) this.f7705w) == null) {
            this.f7705w = new androidx.emoji2.text.f0(charSequence instanceof Spannable ? (Spannable) charSequence : new SpannableString(charSequence));
        }
        ((fc.e) this.f7706x).getClass();
        ((androidx.emoji2.text.f0) this.f7705w).setSpan(new androidx.emoji2.text.d0(c0Var), i, i10, 33);
        return true;
    }

    @Override // ya.r
    public void g(Throwable th) {
        f4 f4Var = (f4) this.f7705w;
        x2 x2Var = (x2) this.f7706x;
        x2Var.m1();
        x2Var.E = false;
        r1 r1Var = (r1) x2Var.f307w;
        f9.g gVar = r1Var.f4366y;
        w0 w0Var = r1Var.A;
        int i = 2;
        if (gVar.w1(null, f9.f0.U0)) {
            String message = th.getMessage();
            x2Var.J = false;
            if (message != null) {
                if ((th instanceof IllegalStateException) || message.contains("garbage collected") || th.getClass().getSimpleName().equals("ServiceUnavailableException")) {
                    if (message.contains("Background")) {
                        x2Var.J = true;
                    }
                    i = 1;
                } else if ((th instanceof SecurityException) && !message.endsWith("READ_DEVICE_CONFIG")) {
                    i = 3;
                }
            }
        }
        int i10 = i - 1;
        if (i10 == 0) {
            r1.g(w0Var);
            w0Var.E.c(w0.u1(r1Var.l().s1()), w0.u1(th.toString()), "registerTriggerAsync failed with retriable error. Will try later. App ID, throwable");
            x2Var.F = 1;
            x2Var.K1().add(f4Var);
            return;
        }
        if (i10 != 1) {
            r1.g(w0Var);
            w0Var.B.c(w0.u1(r1Var.l().s1()), th, "registerTriggerAsync failed. Dropping URI. App ID, Throwable");
            Z();
            x2Var.F = 1;
            x2Var.L1();
            return;
        }
        x2Var.K1().add(f4Var);
        if (x2Var.F > ((Integer) f9.f0.f4163x0.a(null)).intValue()) {
            x2Var.F = 1;
            r1.g(w0Var);
            w0Var.E.c(w0.u1(r1Var.l().s1()), w0.u1(th.toString()), "registerTriggerAsync failed. May try later. App ID, throwable");
            return;
        }
        r1.g(w0Var);
        w0Var.E.d("registerTriggerAsync failed. App ID, delay in seconds, throwable", w0.u1(r1Var.l().s1()), w0.u1(String.valueOf(x2Var.F)), w0.u1(th.toString()));
        int i11 = x2Var.F;
        if (x2Var.G == null) {
            x2Var.G = new l2(x2Var, r1Var, 1);
        }
        x2Var.G.b(((long) i11) * 1000);
        int i12 = x2Var.F;
        x2Var.F = i12 + i12;
    }

    @Override // qd.a
    public Object get() {
        int i = 13;
        f9.b0 b0Var = new f9.b0(i);
        f9.a0 a0Var = new f9.a0(i);
        Object obj = ((qd.a) this.f7705w).get();
        qd.a aVar = (qd.a) this.f7706x;
        return new e8.i(b0Var, a0Var, e8.a.f, (e8.k) obj, aVar);
    }

    @Override // b2.g
    public b2.h h() {
        return new b2.p((Context) this.f7705w, ((b2.g) this.f7706x).h());
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x011c A[EDGE_INSN: B:68:0x011c->B:52:0x011c BREAK  A[LOOP:1: B:38:0x00e3->B:51:0x010b], SYNTHETIC] */
    @Override // a3.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public a3.i i(a3.q r17, long r18) {
        /*
            Method dump skipped, instruction units count: 305
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: l4.c0.i(a3.q, long):a3.i");
    }

    @Override // a3.j
    public void j() {
        y1.t tVar = (y1.t) this.f7706x;
        byte[] bArr = y1.a0.f14553c;
        tVar.getClass();
        tVar.H(bArr.length, bArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0097  */
    @Override // t0.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public t0.p1 k(android.view.View r20, t0.p1 r21) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r2 = r21
            java.lang.Object r3 = r0.f7705w
            com.google.android.gms.internal.measurement.o4 r3 = (com.google.android.gms.internal.measurement.o4) r3
            java.lang.Object r4 = r0.f7706x
            a3.d r4 = (a3.d) r4
            int r5 = r4.f154a
            int r6 = r4.f155b
            int r4 = r4.f156c
            t0.m1 r7 = r2.f11791a
            r8 = 519(0x207, float:7.27E-43)
            l0.c r8 = r7.f(r8)
            r9 = 32
            l0.c r7 = r7.f(r9)
            java.lang.Object r9 = r3.f2561w
            com.google.android.material.bottomsheet.BottomSheetBehavior r9 = (com.google.android.material.bottomsheet.BottomSheetBehavior) r9
            int r10 = r8.f7603b
            int r11 = r8.f7604c
            int r12 = r8.f7602a
            r9.R = r10
            int r10 = r1.getLayoutDirection()
            r14 = 1
            if (r10 != r14) goto L37
            r10 = r14
            goto L38
        L37:
            r10 = 0
        L38:
            int r15 = r1.getPaddingBottom()
            int r16 = r1.getPaddingLeft()
            int r17 = r1.getPaddingRight()
            boolean r13 = r9.J
            if (r13 == 0) goto L4f
            int r15 = r2.a()
            r9.Q = r15
            int r15 = r15 + r4
        L4f:
            boolean r4 = r9.K
            if (r4 == 0) goto L5a
            if (r10 == 0) goto L57
            r4 = r6
            goto L58
        L57:
            r4 = r5
        L58:
            int r16 = r4 + r12
        L5a:
            r4 = r16
            boolean r14 = r9.L
            if (r14 == 0) goto L66
            if (r10 == 0) goto L63
            goto L64
        L63:
            r5 = r6
        L64:
            int r17 = r5 + r11
        L66:
            r5 = r17
            android.view.ViewGroup$LayoutParams r6 = r1.getLayoutParams()
            android.view.ViewGroup$MarginLayoutParams r6 = (android.view.ViewGroup.MarginLayoutParams) r6
            boolean r10 = r9.N
            if (r10 == 0) goto L7b
            int r10 = r6.leftMargin
            if (r10 == r12) goto L7b
            r6.leftMargin = r12
            r18 = 1
            goto L7d
        L7b:
            r18 = 0
        L7d:
            boolean r10 = r9.O
            if (r10 == 0) goto L89
            int r10 = r6.rightMargin
            if (r10 == r11) goto L89
            r6.rightMargin = r11
            r18 = 1
        L89:
            boolean r10 = r9.P
            if (r10 == 0) goto L97
            int r10 = r6.topMargin
            int r8 = r8.f7603b
            if (r10 == r8) goto L97
            r6.topMargin = r8
            r14 = 1
            goto L99
        L97:
            r14 = r18
        L99:
            if (r14 == 0) goto L9e
            r1.setLayoutParams(r6)
        L9e:
            int r6 = r1.getPaddingTop()
            r1.setPadding(r4, r6, r5, r15)
            boolean r1 = r3.f2560v
            if (r1 == 0) goto Lad
            int r3 = r7.f7605d
            r9.H = r3
        Lad:
            if (r13 != 0) goto Lb3
            if (r1 == 0) goto Lb2
            goto Lb3
        Lb2:
            return r2
        Lb3:
            r9.N()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: l4.c0.k(android.view.View, t0.p1):t0.p1");
    }

    @Override // x6.k
    public int l(x6.h hVar) {
        return 2;
    }

    @Override // x6.b
    public boolean m(Object obj, File file, x6.h hVar) {
        return ((g7.b) this.f7706x).m(new g7.d((a7.b) this.f7705w, ((BitmapDrawable) ((z6.b0) obj).get()).getBitmap()), file, hVar);
    }

    public void n(int i, fd.b bVar) {
        synchronized (this.f7705w) {
            ((LinkedHashMap) this.f7706x).put(Integer.valueOf(i), bVar);
        }
    }

    @Override // g7.o
    public void o() {
        g7.x xVar = (g7.x) this.f7705w;
        synchronized (xVar) {
            xVar.f5228x = xVar.f5226v.length;
        }
    }

    public String p(x6.e eVar) {
        String str;
        b7.h hVar = (b7.h) ((l7.a) this.f7706x).i();
        try {
            eVar.a(hVar.f1837v);
            byte[] bArrDigest = hVar.f1837v.digest();
            char[] cArr = s7.m.f11608b;
            synchronized (cArr) {
                for (int i = 0; i < bArrDigest.length; i++) {
                    byte b8 = bArrDigest[i];
                    int i10 = i * 2;
                    char[] cArr2 = s7.m.f11607a;
                    cArr[i10] = cArr2[(b8 & 255) >>> 4];
                    cArr[i10 + 1] = cArr2[b8 & 15];
                }
                str = new String(cArr);
            }
            return str;
        } finally {
            ((l7.a) this.f7706x).b(hVar);
        }
    }

    public void q() {
        this.f7705w = null;
        this.f7706x = null;
    }

    @Override // x3.p
    public /* synthetic */ x3.g r(byte[] bArr, int i, int i10) {
        return l0.e.a(this, bArr, i10);
    }

    public void s() {
        synchronized (this.f7705w) {
            ((LinkedHashMap) this.f7706x).clear();
        }
    }

    public boolean t(int i) {
        boolean zContainsKey;
        synchronized (this.f7705w) {
            zContainsKey = ((LinkedHashMap) this.f7706x).containsKey(Integer.valueOf(i));
        }
        return zContainsKey;
    }

    public String toString() {
        switch (this.f7704v) {
            case 3:
                StringBuilder sb = new StringBuilder("GroupedLinkedMap( ");
                a7.d dVar = (a7.d) this.f7705w;
                a7.d dVar2 = dVar.f311c;
                boolean z10 = false;
                while (!dVar2.equals(dVar)) {
                    sb.append('{');
                    sb.append(dVar2.f309a);
                    sb.append(':');
                    ArrayList arrayList = dVar2.f310b;
                    sb.append(arrayList != null ? arrayList.size() : 0);
                    sb.append("}, ");
                    dVar2 = dVar2.f311c;
                    z10 = true;
                }
                if (z10) {
                    sb.delete(sb.length() - 2, sb.length());
                }
                sb.append(" )");
                return sb.toString();
            default:
                return super.toString();
        }
    }

    public void u(boolean z10) {
        androidx.fragment.app.y yVar = ((r0) this.f7706x).f1064w;
        if (yVar != null) {
            yVar.l().f1054m.u(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f7705w).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z10) {
                throw null;
            }
            throw null;
        }
    }

    public void v(boolean z10) {
        r0 r0Var = (r0) this.f7706x;
        h.j jVar = r0Var.f1062u.f952x;
        androidx.fragment.app.y yVar = r0Var.f1064w;
        if (yVar != null) {
            yVar.l().f1054m.v(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f7705w).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z10) {
                throw null;
            }
            throw null;
        }
    }

    public void w(boolean z10) {
        androidx.fragment.app.y yVar = ((r0) this.f7706x).f1064w;
        if (yVar != null) {
            yVar.l().f1054m.w(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f7705w).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z10) {
                throw null;
            }
            throw null;
        }
    }

    public void x(boolean z10) {
        androidx.fragment.app.y yVar = ((r0) this.f7706x).f1064w;
        if (yVar != null) {
            yVar.l().f1054m.x(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f7705w).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z10) {
                throw null;
            }
            throw null;
        }
    }

    public void y(boolean z10) {
        androidx.fragment.app.y yVar = ((r0) this.f7706x).f1064w;
        if (yVar != null) {
            yVar.l().f1054m.y(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f7705w).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z10) {
                throw null;
            }
            throw null;
        }
    }

    public void z(boolean z10) {
        androidx.fragment.app.y yVar = ((r0) this.f7706x).f1064w;
        if (yVar != null) {
            yVar.l().f1054m.z(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f7705w).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z10) {
                throw null;
            }
            throw null;
        }
    }

    public /* synthetic */ c0(int i, Object obj, Object obj2, boolean z10) {
        this.f7704v = i;
        this.f7705w = obj2;
        this.f7706x = obj;
    }

    public /* synthetic */ c0(int i, boolean z10) {
        this.f7704v = i;
    }

    public c0(b4 b4Var) {
        this.f7704v = 18;
        this.f7706x = b4Var;
    }

    public c0(p6.d dVar, i2.k kVar) {
        this.f7704v = 20;
        this.f7706x = kVar;
        dVar.s(new fb.b(0, this));
        this.f7705w = new HashSet();
    }

    public c0(int i) {
        this.f7704v = i;
        switch (i) {
            case g1.h.BYTES_FIELD_NUMBER /* 8 */:
                this.f7705w = new HashMap();
                break;
            case 9:
                this.f7705w = new HashMap();
                this.f7706x = new b7.c(0);
                break;
            case 10:
                this.f7705w = new i2.c0(1000L);
                this.f7706x = t7.d.a(10, new jb.b(5));
                break;
            case 21:
                this.f7705w = new Object();
                this.f7706x = new LinkedHashMap();
                break;
            case 23:
                this.f7705w = new y1.t();
                this.f7706x = new g4.a();
                break;
            default:
                this.f7705w = new a7.d(null);
                this.f7706x = new HashMap();
                break;
        }
    }

    public c0(com.bumptech.glide.manager.k kVar) {
        this.f7704v = 11;
        this.f7705w = new HashMap();
        this.f7706x = kVar;
    }

    public c0(r0 r0Var) {
        this.f7704v = 6;
        this.f7705w = new CopyOnWriteArrayList();
        this.f7706x = r0Var;
    }

    @Override // x3.p
    public /* synthetic */ void reset() {
    }

    public c0(y1.y yVar) {
        this.f7704v = 28;
        this.f7705w = yVar;
        this.f7706x = new y1.t();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c0(Context context) {
        this(context, new b2.q(0));
        this.f7704v = 7;
    }

    public c0(Context context, b2.g gVar) {
        this.f7704v = 7;
        this.f7705w = context.getApplicationContext();
        this.f7706x = gVar;
    }

    public c0(MediaCodec.CryptoInfo cryptoInfo) {
        this.f7704v = 14;
        this.f7705w = cryptoInfo;
        this.f7706x = a9.b.f();
    }

    public c0(Animation animation) {
        this.f7704v = 5;
        this.f7705w = animation;
        this.f7706x = null;
    }

    public c0(Animator animator) {
        this.f7704v = 5;
        this.f7705w = null;
        this.f7706x = animator;
    }

    public c0(PlayerActivity playerActivity, String str, ComponentName componentName, PendingIntent pendingIntent, Bundle bundle) {
        this.f7704v = 0;
        if (!TextUtils.isEmpty(str)) {
            if (componentName == null) {
                int i = j.f7725a;
                Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
                intent.setPackage(playerActivity.getPackageName());
                List<ResolveInfo> listQueryBroadcastReceivers = playerActivity.getPackageManager().queryBroadcastReceivers(intent, 0);
                if (listQueryBroadcastReceivers.size() == 1) {
                    ActivityInfo activityInfo = listQueryBroadcastReceivers.get(0).activityInfo;
                    componentName = new ComponentName(activityInfo.packageName, activityInfo.name);
                } else {
                    if (listQueryBroadcastReceivers.size() > 1) {
                        Log.w("MediaButtonReceiver", "More than one BroadcastReceiver that handles android.intent.action.MEDIA_BUTTON was found, returning null.");
                    }
                    componentName = null;
                }
                if (componentName == null) {
                    Log.i("MediaSessionCompat", "Couldn't find a unique registered media button receiver in the given context.");
                }
            }
            if (componentName != null && pendingIntent == null) {
                Intent intent2 = new Intent("android.intent.action.MEDIA_BUTTON");
                intent2.setComponent(componentName);
                pendingIntent = PendingIntent.getBroadcast(playerActivity, 0, intent2, Build.VERSION.SDK_INT >= 31 ? 33554432 : 0);
            }
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 29) {
                this.f7705w = new y(playerActivity, str, bundle);
            } else if (i10 >= 28) {
                this.f7705w = new x(playerActivity, str, bundle);
            } else {
                this.f7705w = new w(playerActivity, str, bundle);
            }
            Looper looperMyLooper = Looper.myLooper();
            X(new s(), new Handler(looperMyLooper == null ? Looper.getMainLooper() : looperMyLooper));
            ((w) this.f7705w).f7765a.setMediaButtonReceiver(pendingIntent);
            this.f7706x = new p6.d(playerActivity, this);
            return;
        }
        throw new IllegalArgumentException("tag must not be null or empty");
    }

    public c0(Toolbar toolbar) {
        this.f7704v = 26;
        this.f7705w = toolbar;
        toolbar.getNavigationIcon();
        this.f7706x = toolbar.getNavigationContentDescription();
    }

    public c0(h4.e0 e0Var) {
        this.f7704v = 29;
        this.f7706x = e0Var;
        this.f7705w = new a3.k0(4, new byte[4]);
    }

    public c0(a3.m mVar) {
        this.f7704v = 1;
        this.f7705w = mVar;
        this.f7706x = new AtomicBoolean(false);
    }

    @Override // h4.b0
    public void c(y1.y yVar, a3.r rVar, h4.g0 g0Var) {
    }
}
