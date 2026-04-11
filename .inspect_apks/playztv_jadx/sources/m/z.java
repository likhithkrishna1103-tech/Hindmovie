package m;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class z extends androidx.fragment.app.h implements Menu {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k f8275c;

    public z(Context context, k kVar) {
        super(context);
        if (kVar == null) {
            throw new IllegalArgumentException("Wrapped Object can not be null.");
        }
        this.f8275c = kVar;
    }

    @Override // android.view.Menu
    public final MenuItem add(CharSequence charSequence) {
        return g(this.f8275c.a(0, 0, 0, charSequence));
    }

    @Override // android.view.Menu
    public final int addIntentOptions(int i, int i10, int i11, ComponentName componentName, Intent[] intentArr, Intent intent, int i12, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2 = menuItemArr != null ? new MenuItem[menuItemArr.length] : null;
        int iAddIntentOptions = this.f8275c.addIntentOptions(i, i10, i11, componentName, intentArr, intent, i12, menuItemArr2);
        if (menuItemArr2 != null) {
            int length = menuItemArr2.length;
            for (int i13 = 0; i13 < length; i13++) {
                menuItemArr[i13] = g(menuItemArr2[i13]);
            }
        }
        return iAddIntentOptions;
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(CharSequence charSequence) {
        return this.f8275c.addSubMenu(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public final void clear() {
        s.i iVar = (s.i) this.f1283b;
        if (iVar != null) {
            iVar.clear();
        }
        this.f8275c.clear();
    }

    @Override // android.view.Menu
    public final void close() {
        this.f8275c.close();
    }

    @Override // android.view.Menu
    public final MenuItem findItem(int i) {
        return g(this.f8275c.findItem(i));
    }

    @Override // android.view.Menu
    public final MenuItem getItem(int i) {
        return g(this.f8275c.getItem(i));
    }

    @Override // android.view.Menu
    public final boolean hasVisibleItems() {
        return this.f8275c.hasVisibleItems();
    }

    @Override // android.view.Menu
    public final boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return this.f8275c.isShortcutKey(i, keyEvent);
    }

    @Override // android.view.Menu
    public final boolean performIdentifierAction(int i, int i10) {
        return this.f8275c.performIdentifierAction(i, i10);
    }

    @Override // android.view.Menu
    public final boolean performShortcut(int i, KeyEvent keyEvent, int i10) {
        return this.f8275c.performShortcut(i, keyEvent, i10);
    }

    @Override // android.view.Menu
    public final void removeGroup(int i) {
        if (((s.i) this.f1283b) != null) {
            int i10 = 0;
            while (true) {
                s.i iVar = (s.i) this.f1283b;
                if (i10 >= iVar.f11635w) {
                    break;
                }
                if (((k0.a) iVar.f(i10)).getGroupId() == i) {
                    ((s.i) this.f1283b).h(i10);
                    i10--;
                }
                i10++;
            }
        }
        this.f8275c.removeGroup(i);
    }

    @Override // android.view.Menu
    public final void removeItem(int i) {
        if (((s.i) this.f1283b) != null) {
            int i10 = 0;
            while (true) {
                s.i iVar = (s.i) this.f1283b;
                if (i10 >= iVar.f11635w) {
                    break;
                }
                if (((k0.a) iVar.f(i10)).getItemId() == i) {
                    ((s.i) this.f1283b).h(i10);
                    break;
                }
                i10++;
            }
        }
        this.f8275c.removeItem(i);
    }

    @Override // android.view.Menu
    public final void setGroupCheckable(int i, boolean z2, boolean z10) {
        this.f8275c.setGroupCheckable(i, z2, z10);
    }

    @Override // android.view.Menu
    public final void setGroupEnabled(int i, boolean z2) {
        this.f8275c.setGroupEnabled(i, z2);
    }

    @Override // android.view.Menu
    public final void setGroupVisible(int i, boolean z2) {
        this.f8275c.setGroupVisible(i, z2);
    }

    @Override // android.view.Menu
    public final void setQwertyMode(boolean z2) {
        this.f8275c.setQwertyMode(z2);
    }

    @Override // android.view.Menu
    public final int size() {
        return this.f8275c.size();
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i) {
        return this.f8275c.addSubMenu(i);
    }

    @Override // android.view.Menu
    public final MenuItem add(int i) {
        return g(this.f8275c.add(i));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i, int i10, int i11, CharSequence charSequence) {
        return this.f8275c.addSubMenu(i, i10, i11, charSequence);
    }

    @Override // android.view.Menu
    public final MenuItem add(int i, int i10, int i11, CharSequence charSequence) {
        return g(this.f8275c.a(i, i10, i11, charSequence));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i, int i10, int i11, int i12) {
        return this.f8275c.addSubMenu(i, i10, i11, i12);
    }

    @Override // android.view.Menu
    public final MenuItem add(int i, int i10, int i11, int i12) {
        return g(this.f8275c.add(i, i10, i11, i12));
    }
}
