package n;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import t0.n0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class k implements Menu {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int[] f8518y = {1, 4, 5, 3, 2, 0};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f8519a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Resources f8520b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f8521c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f8522d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public i f8523e;
    public final ArrayList f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ArrayList f8524g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f8525h;
    public final ArrayList i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ArrayList f8526j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f8527k;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public CharSequence f8529m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Drawable f8530n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View f8531o;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public m f8538v;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f8540x;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f8528l = 0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f8532p = false;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f8533q = false;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f8534r = false;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f8535s = false;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final ArrayList f8536t = new ArrayList();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final CopyOnWriteArrayList f8537u = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f8539w = false;

    public k(Context context) {
        boolean zN;
        boolean z10 = false;
        this.f8519a = context;
        Resources resources = context.getResources();
        this.f8520b = resources;
        this.f = new ArrayList();
        this.f8524g = new ArrayList();
        this.f8525h = true;
        this.i = new ArrayList();
        this.f8526j = new ArrayList();
        this.f8527k = true;
        if (resources.getConfiguration().keyboard != 1) {
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            Method method = n0.f11784a;
            if (Build.VERSION.SDK_INT >= 28) {
                zN = j0.a.n(viewConfiguration);
            } else {
                Resources resources2 = context.getResources();
                int identifier = resources2.getIdentifier("config_showMenuShortcutsWhenKeyboardPresent", "bool", "android");
                zN = identifier != 0 && resources2.getBoolean(identifier);
            }
            if (zN) {
                z10 = true;
            }
        }
        this.f8522d = z10;
    }

    public final m a(int i, int i10, int i11, CharSequence charSequence) {
        int i12;
        int i13 = ((-65536) & i11) >> 16;
        if (i13 < 0 || i13 >= 6) {
            throw new IllegalArgumentException("order does not contain a valid category.");
        }
        int i14 = (f8518y[i13] << 16) | (65535 & i11);
        m mVar = new m(this, i, i10, i11, i14, charSequence, this.f8528l);
        ArrayList arrayList = this.f;
        int size = arrayList.size() - 1;
        while (true) {
            if (size < 0) {
                i12 = 0;
                break;
            }
            if (((m) arrayList.get(size)).f8547d <= i14) {
                i12 = size + 1;
                break;
            }
            size--;
        }
        arrayList.add(i12, mVar);
        p(true);
        return mVar;
    }

    @Override // android.view.Menu
    public final MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public final int addIntentOptions(int i, int i10, int i11, ComponentName componentName, Intent[] intentArr, Intent intent, int i12, MenuItem[] menuItemArr) {
        int i13;
        PackageManager packageManager = this.f8519a.getPackageManager();
        List<ResolveInfo> listQueryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = listQueryIntentActivityOptions != null ? listQueryIntentActivityOptions.size() : 0;
        if ((i12 & 1) == 0) {
            removeGroup(i);
        }
        for (int i14 = 0; i14 < size; i14++) {
            ResolveInfo resolveInfo = listQueryIntentActivityOptions.get(i14);
            int i15 = resolveInfo.specificIndex;
            Intent intent2 = new Intent(i15 < 0 ? intent : intentArr[i15]);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent2.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
            m mVarA = a(i, i10, i11, resolveInfo.loadLabel(packageManager));
            mVarA.setIcon(resolveInfo.loadIcon(packageManager));
            mVarA.f8549g = intent2;
            if (menuItemArr != null && (i13 = resolveInfo.specificIndex) >= 0) {
                menuItemArr[i13] = mVarA;
            }
        }
        return size;
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public final void b(w wVar, Context context) {
        this.f8537u.add(new WeakReference(wVar));
        wVar.h(context, this);
        this.f8527k = true;
    }

    public final void c(boolean z10) {
        if (this.f8535s) {
            return;
        }
        this.f8535s = true;
        CopyOnWriteArrayList<WeakReference> copyOnWriteArrayList = this.f8537u;
        for (WeakReference weakReference : copyOnWriteArrayList) {
            w wVar = (w) weakReference.get();
            if (wVar == null) {
                copyOnWriteArrayList.remove(weakReference);
            } else {
                wVar.c(this, z10);
            }
        }
        this.f8535s = false;
    }

    @Override // android.view.Menu
    public final void clear() {
        m mVar = this.f8538v;
        if (mVar != null) {
            d(mVar);
        }
        this.f.clear();
        p(true);
    }

    public final void clearHeader() {
        this.f8530n = null;
        this.f8529m = null;
        this.f8531o = null;
        p(false);
    }

    @Override // android.view.Menu
    public final void close() {
        c(true);
    }

    public boolean d(m mVar) {
        CopyOnWriteArrayList<WeakReference> copyOnWriteArrayList = this.f8537u;
        boolean zM = false;
        if (!copyOnWriteArrayList.isEmpty() && this.f8538v == mVar) {
            w();
            for (WeakReference weakReference : copyOnWriteArrayList) {
                w wVar = (w) weakReference.get();
                if (wVar != null) {
                    zM = wVar.m(mVar);
                    if (zM) {
                        break;
                    }
                } else {
                    copyOnWriteArrayList.remove(weakReference);
                }
            }
            v();
            if (zM) {
                this.f8538v = null;
            }
        }
        return zM;
    }

    public boolean e(k kVar, MenuItem menuItem) {
        i iVar = this.f8523e;
        return iVar != null && iVar.x(kVar, menuItem);
    }

    public boolean f(m mVar) {
        CopyOnWriteArrayList<WeakReference> copyOnWriteArrayList = this.f8537u;
        boolean zG = false;
        if (copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        w();
        for (WeakReference weakReference : copyOnWriteArrayList) {
            w wVar = (w) weakReference.get();
            if (wVar != null) {
                zG = wVar.g(mVar);
                if (zG) {
                    break;
                }
            } else {
                copyOnWriteArrayList.remove(weakReference);
            }
        }
        v();
        if (zG) {
            this.f8538v = mVar;
        }
        return zG;
    }

    @Override // android.view.Menu
    public final MenuItem findItem(int i) {
        MenuItem menuItemFindItem;
        ArrayList arrayList = this.f;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            m mVar = (m) arrayList.get(i10);
            if (mVar.f8544a == i) {
                return mVar;
            }
            if (mVar.hasSubMenu() && (menuItemFindItem = mVar.f8556o.findItem(i)) != null) {
                return menuItemFindItem;
            }
        }
        return null;
    }

    public final m g(int i, KeyEvent keyEvent) {
        ArrayList arrayList = this.f8536t;
        arrayList.clear();
        h(arrayList, i, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return (m) arrayList.get(0);
        }
        boolean zN = n();
        for (int i10 = 0; i10 < size; i10++) {
            m mVar = (m) arrayList.get(i10);
            char c9 = zN ? mVar.f8551j : mVar.f8550h;
            char[] cArr = keyData.meta;
            if ((c9 == cArr[0] && (metaState & 2) == 0) || ((c9 == cArr[2] && (metaState & 2) != 0) || (zN && c9 == '\b' && i == 67))) {
                return mVar;
            }
        }
        return null;
    }

    @Override // android.view.Menu
    public final MenuItem getItem(int i) {
        return (MenuItem) this.f.get(i);
    }

    public final void h(List list, int i, KeyEvent keyEvent) {
        boolean zN = n();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i == 67) {
            ArrayList arrayList = this.f;
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                m mVar = (m) arrayList.get(i10);
                if (mVar.hasSubMenu()) {
                    mVar.f8556o.h(list, i, keyEvent);
                }
                char c9 = zN ? mVar.f8551j : mVar.f8550h;
                if ((modifiers & 69647) == ((zN ? mVar.f8552k : mVar.i) & 69647) && c9 != 0) {
                    char[] cArr = keyData.meta;
                    if ((c9 == cArr[0] || c9 == cArr[2] || (zN && c9 == '\b' && i == 67)) && mVar.isEnabled()) {
                        list.add(mVar);
                    }
                }
            }
        }
    }

    @Override // android.view.Menu
    public final boolean hasVisibleItems() {
        if (this.f8540x) {
            return true;
        }
        ArrayList arrayList = this.f;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (((m) arrayList.get(i)).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public final void i() {
        ArrayList arrayListL = l();
        if (this.f8527k) {
            CopyOnWriteArrayList<WeakReference> copyOnWriteArrayList = this.f8537u;
            boolean zJ = false;
            for (WeakReference weakReference : copyOnWriteArrayList) {
                w wVar = (w) weakReference.get();
                if (wVar == null) {
                    copyOnWriteArrayList.remove(weakReference);
                } else {
                    zJ |= wVar.j();
                }
            }
            ArrayList arrayList = this.i;
            ArrayList arrayList2 = this.f8526j;
            if (zJ) {
                arrayList.clear();
                arrayList2.clear();
                int size = arrayListL.size();
                for (int i = 0; i < size; i++) {
                    m mVar = (m) arrayListL.get(i);
                    if ((mVar.f8565x & 32) == 32) {
                        arrayList.add(mVar);
                    } else {
                        arrayList2.add(mVar);
                    }
                }
            } else {
                arrayList.clear();
                arrayList2.clear();
                arrayList2.addAll(l());
            }
            this.f8527k = false;
        }
    }

    @Override // android.view.Menu
    public final boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return g(i, keyEvent) != null;
    }

    public String j() {
        return "android:menu:actionviewstates";
    }

    public final ArrayList l() {
        boolean z10 = this.f8525h;
        ArrayList arrayList = this.f8524g;
        if (!z10) {
            return arrayList;
        }
        arrayList.clear();
        ArrayList arrayList2 = this.f;
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            m mVar = (m) arrayList2.get(i);
            if (mVar.isVisible()) {
                arrayList.add(mVar);
            }
        }
        this.f8525h = false;
        this.f8527k = true;
        return arrayList;
    }

    public boolean m() {
        return this.f8539w;
    }

    public boolean n() {
        return this.f8521c;
    }

    public boolean o() {
        return this.f8522d;
    }

    public void p(boolean z10) {
        if (this.f8532p) {
            this.f8533q = true;
            if (z10) {
                this.f8534r = true;
                return;
            }
            return;
        }
        if (z10) {
            this.f8525h = true;
            this.f8527k = true;
        }
        CopyOnWriteArrayList<WeakReference> copyOnWriteArrayList = this.f8537u;
        if (copyOnWriteArrayList.isEmpty()) {
            return;
        }
        w();
        for (WeakReference weakReference : copyOnWriteArrayList) {
            w wVar = (w) weakReference.get();
            if (wVar == null) {
                copyOnWriteArrayList.remove(weakReference);
            } else {
                wVar.e();
            }
        }
        v();
    }

    @Override // android.view.Menu
    public final boolean performIdentifierAction(int i, int i10) {
        return q(findItem(i), null, i10);
    }

    @Override // android.view.Menu
    public final boolean performShortcut(int i, KeyEvent keyEvent, int i10) {
        m mVarG = g(i, keyEvent);
        boolean zQ = mVarG != null ? q(mVarG, null, i10) : false;
        if ((i10 & 2) != 0) {
            c(true);
        }
        return zQ;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean q(android.view.MenuItem r7, n.w r8, int r9) {
        /*
            Method dump skipped, instruction units count: 211
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n.k.q(android.view.MenuItem, n.w, int):boolean");
    }

    public final void r(w wVar) {
        CopyOnWriteArrayList<WeakReference> copyOnWriteArrayList = this.f8537u;
        for (WeakReference weakReference : copyOnWriteArrayList) {
            w wVar2 = (w) weakReference.get();
            if (wVar2 == null || wVar2 == wVar) {
                copyOnWriteArrayList.remove(weakReference);
            }
        }
    }

    @Override // android.view.Menu
    public final void removeGroup(int i) {
        ArrayList arrayList = this.f;
        int size = arrayList.size();
        int i10 = 0;
        int i11 = 0;
        while (true) {
            if (i11 >= size) {
                i11 = -1;
                break;
            } else if (((m) arrayList.get(i11)).f8545b == i) {
                break;
            } else {
                i11++;
            }
        }
        if (i11 >= 0) {
            int size2 = arrayList.size() - i11;
            while (true) {
                int i12 = i10 + 1;
                if (i10 >= size2 || ((m) arrayList.get(i11)).f8545b != i) {
                    break;
                }
                if (i11 >= 0 && i11 < arrayList.size()) {
                    arrayList.remove(i11);
                }
                i10 = i12;
            }
            p(true);
        }
    }

    @Override // android.view.Menu
    public final void removeItem(int i) {
        ArrayList arrayList = this.f;
        int size = arrayList.size();
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                i10 = -1;
                break;
            } else if (((m) arrayList.get(i10)).f8544a == i) {
                break;
            } else {
                i10++;
            }
        }
        if (i10 < 0 || i10 >= arrayList.size()) {
            return;
        }
        arrayList.remove(i10);
        p(true);
    }

    public final void s(Bundle bundle) {
        MenuItem menuItemFindItem;
        if (bundle == null) {
            return;
        }
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(j());
        int size = this.f.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = getItem(i);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                actionView.restoreHierarchyState(sparseParcelableArray);
            }
            if (item.hasSubMenu()) {
                ((c0) item.getSubMenu()).s(bundle);
            }
        }
        int i10 = bundle.getInt("android:menu:expandedactionview");
        if (i10 <= 0 || (menuItemFindItem = findItem(i10)) == null) {
            return;
        }
        menuItemFindItem.expandActionView();
    }

    @Override // android.view.Menu
    public final void setGroupCheckable(int i, boolean z10, boolean z11) {
        ArrayList arrayList = this.f;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            m mVar = (m) arrayList.get(i10);
            if (mVar.f8545b == i) {
                mVar.f(z11);
                mVar.setCheckable(z10);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupDividerEnabled(boolean z10) {
        this.f8539w = z10;
    }

    @Override // android.view.Menu
    public final void setGroupEnabled(int i, boolean z10) {
        ArrayList arrayList = this.f;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            m mVar = (m) arrayList.get(i10);
            if (mVar.f8545b == i) {
                mVar.setEnabled(z10);
            }
        }
    }

    @Override // android.view.Menu
    public final void setGroupVisible(int i, boolean z10) {
        ArrayList arrayList = this.f;
        int size = arrayList.size();
        boolean z11 = false;
        for (int i10 = 0; i10 < size; i10++) {
            m mVar = (m) arrayList.get(i10);
            if (mVar.f8545b == i) {
                int i11 = mVar.f8565x;
                int i12 = (i11 & (-9)) | (z10 ? 0 : 8);
                mVar.f8565x = i12;
                if (i11 != i12) {
                    z11 = true;
                }
            }
        }
        if (z11) {
            p(true);
        }
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z10) {
        this.f8521c = z10;
        p(false);
    }

    @Override // android.view.Menu
    public final int size() {
        return this.f.size();
    }

    public final void t(Bundle bundle) {
        int size = this.f.size();
        SparseArray<? extends Parcelable> sparseArray = null;
        for (int i = 0; i < size; i++) {
            MenuItem item = getItem(i);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((c0) item.getSubMenu()).t(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(j(), sparseArray);
        }
    }

    public final void u(int i, CharSequence charSequence, int i10, Drawable drawable, View view) {
        if (view != null) {
            this.f8531o = view;
            this.f8529m = null;
            this.f8530n = null;
        } else {
            if (i > 0) {
                this.f8529m = this.f8520b.getText(i);
            } else if (charSequence != null) {
                this.f8529m = charSequence;
            }
            if (i10 > 0) {
                this.f8530n = this.f8519a.getDrawable(i10);
            } else if (drawable != null) {
                this.f8530n = drawable;
            }
            this.f8531o = null;
        }
        p(false);
    }

    public final void v() {
        this.f8532p = false;
        if (this.f8533q) {
            this.f8533q = false;
            p(this.f8534r);
        }
    }

    public final void w() {
        if (this.f8532p) {
            return;
        }
        this.f8532p = true;
        this.f8533q = false;
        this.f8534r = false;
    }

    @Override // android.view.Menu
    public final MenuItem add(int i) {
        return a(0, 0, 0, this.f8520b.getString(i));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i) {
        return addSubMenu(0, 0, 0, this.f8520b.getString(i));
    }

    @Override // android.view.Menu
    public final MenuItem add(int i, int i10, int i11, CharSequence charSequence) {
        return a(i, i10, i11, charSequence);
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i10, int i11, CharSequence charSequence) {
        m mVarA = a(i, i10, i11, charSequence);
        c0 c0Var = new c0(this.f8519a, this, mVarA);
        mVarA.f8556o = c0Var;
        c0Var.setHeaderTitle(mVarA.f8548e);
        return c0Var;
    }

    @Override // android.view.Menu
    public final MenuItem add(int i, int i10, int i11, int i12) {
        return a(i, i10, i11, this.f8520b.getString(i12));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i, int i10, int i11, int i12) {
        return addSubMenu(i, i10, i11, this.f8520b.getString(i12));
    }

    public k k() {
        return this;
    }
}
