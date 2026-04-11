package v0;

import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import com.google.android.gms.internal.measurement.d4;
import e6.j;
import k5.g;
import n.a3;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class a extends BaseAdapter implements Filterable {
    public b A;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f13111u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f13112v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Cursor f13113w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f13114x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public d4 f13115y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public g f13116z;

    public abstract void a(View view, Cursor cursor);

    public void b(Cursor cursor) {
        Cursor cursor2 = this.f13113w;
        if (cursor == cursor2) {
            cursor2 = null;
        } else {
            if (cursor2 != null) {
                d4 d4Var = this.f13115y;
                if (d4Var != null) {
                    cursor2.unregisterContentObserver(d4Var);
                }
                g gVar = this.f13116z;
                if (gVar != null) {
                    cursor2.unregisterDataSetObserver(gVar);
                }
            }
            this.f13113w = cursor;
            if (cursor != null) {
                d4 d4Var2 = this.f13115y;
                if (d4Var2 != null) {
                    cursor.registerContentObserver(d4Var2);
                }
                g gVar2 = this.f13116z;
                if (gVar2 != null) {
                    cursor.registerDataSetObserver(gVar2);
                }
                this.f13114x = cursor.getColumnIndexOrThrow("_id");
                this.f13111u = true;
                notifyDataSetChanged();
            } else {
                this.f13114x = -1;
                this.f13111u = false;
                notifyDataSetInvalidated();
            }
        }
        if (cursor2 != null) {
            cursor2.close();
        }
    }

    public abstract String c(Cursor cursor);

    public abstract View d(ViewGroup viewGroup);

    @Override // android.widget.Adapter
    public final int getCount() {
        Cursor cursor;
        if (!this.f13111u || (cursor = this.f13113w) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        if (!this.f13111u) {
            return null;
        }
        this.f13113w.moveToPosition(i);
        if (view == null) {
            a3 a3Var = (a3) this;
            view = a3Var.D.inflate(a3Var.C, viewGroup, false);
        }
        a(view, this.f13113w);
        return view;
    }

    @Override // android.widget.Filterable
    public final Filter getFilter() {
        if (this.A == null) {
            b bVar = new b();
            bVar.f13117a = this;
            this.A = bVar;
        }
        return this.A;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        Cursor cursor;
        if (!this.f13111u || (cursor = this.f13113w) == null) {
            return null;
        }
        cursor.moveToPosition(i);
        return this.f13113w;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        Cursor cursor;
        if (this.f13111u && (cursor = this.f13113w) != null && cursor.moveToPosition(i)) {
            return this.f13113w.getLong(this.f13114x);
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.f13111u) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        }
        if (!this.f13113w.moveToPosition(i)) {
            throw new IllegalStateException(j.l("couldn't move cursor to position ", i));
        }
        if (view == null) {
            view = d(viewGroup);
        }
        a(view, this.f13113w);
        return view;
    }
}
