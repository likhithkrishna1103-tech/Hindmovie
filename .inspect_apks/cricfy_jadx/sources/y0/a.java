package y0;

import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import com.google.android.gms.internal.measurement.a4;
import l0.e;
import o.d2;
import o.e3;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a extends BaseAdapter implements Filterable {
    public d2 A;
    public b B;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f14543v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f14544w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Cursor f14545x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f14546y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public a4 f14547z;

    public abstract void a(View view, Cursor cursor);

    public void b(Cursor cursor) {
        Cursor cursor2 = this.f14545x;
        if (cursor == cursor2) {
            cursor2 = null;
        } else {
            if (cursor2 != null) {
                a4 a4Var = this.f14547z;
                if (a4Var != null) {
                    cursor2.unregisterContentObserver(a4Var);
                }
                d2 d2Var = this.A;
                if (d2Var != null) {
                    cursor2.unregisterDataSetObserver(d2Var);
                }
            }
            this.f14545x = cursor;
            if (cursor != null) {
                a4 a4Var2 = this.f14547z;
                if (a4Var2 != null) {
                    cursor.registerContentObserver(a4Var2);
                }
                d2 d2Var2 = this.A;
                if (d2Var2 != null) {
                    cursor.registerDataSetObserver(d2Var2);
                }
                this.f14546y = cursor.getColumnIndexOrThrow("_id");
                this.f14543v = true;
                notifyDataSetChanged();
            } else {
                this.f14546y = -1;
                this.f14543v = false;
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
        if (!this.f14543v || (cursor = this.f14545x) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        if (!this.f14543v) {
            return null;
        }
        this.f14545x.moveToPosition(i);
        if (view == null) {
            e3 e3Var = (e3) this;
            view = e3Var.E.inflate(e3Var.D, viewGroup, false);
        }
        a(view, this.f14545x);
        return view;
    }

    @Override // android.widget.Filterable
    public final Filter getFilter() {
        if (this.B == null) {
            b bVar = new b();
            bVar.f14548a = this;
            this.B = bVar;
        }
        return this.B;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        Cursor cursor;
        if (!this.f14543v || (cursor = this.f14545x) == null) {
            return null;
        }
        cursor.moveToPosition(i);
        return this.f14545x;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        Cursor cursor;
        if (this.f14543v && (cursor = this.f14545x) != null && cursor.moveToPosition(i)) {
            return this.f14545x.getLong(this.f14546y);
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.f14543v) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        }
        if (!this.f14545x.moveToPosition(i)) {
            throw new IllegalStateException(e.g(i, "couldn't move cursor to position "));
        }
        if (view == null) {
            view = d(viewGroup);
        }
        a(view, this.f14545x);
        return view;
    }
}
