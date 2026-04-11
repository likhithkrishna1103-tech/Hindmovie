package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import g.a;
import g.f;
import g.g;
import g.j;
import kc.b;
import m.k;
import m.m;
import m.x;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class ListMenuItemView extends LinearLayout implements x, AbsListView.SelectionBoundsAdjuster {
    public ImageView A;
    public ImageView B;
    public LinearLayout C;
    public final Drawable D;
    public final int E;
    public final Context F;
    public boolean G;
    public final Drawable H;
    public final boolean I;
    public LayoutInflater J;
    public boolean K;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public m f860u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public ImageView f861v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public RadioButton f862w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public TextView f863x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public CheckBox f864y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public TextView f865z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int i = a.listMenuViewStyle;
        b bVarD = b.D(getContext(), attributeSet, j.MenuView, i);
        this.D = bVarD.s(j.MenuView_android_itemBackground);
        int i10 = j.MenuView_android_itemTextAppearance;
        TypedArray typedArray = (TypedArray) bVarD.f7621w;
        this.E = typedArray.getResourceId(i10, -1);
        this.G = typedArray.getBoolean(j.MenuView_preserveIconSpacing, false);
        this.F = context;
        this.H = bVarD.s(j.MenuView_subMenuArrow);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, new int[]{R.attr.divider}, a.dropDownListViewStyle, 0);
        this.I = typedArrayObtainStyledAttributes.hasValue(0);
        bVarD.E();
        typedArrayObtainStyledAttributes.recycle();
    }

    private LayoutInflater getInflater() {
        if (this.J == null) {
            this.J = LayoutInflater.from(getContext());
        }
        return this.J;
    }

    private void setSubMenuArrowVisible(boolean z2) {
        ImageView imageView = this.A;
        if (imageView != null) {
            imageView.setVisibility(z2 ? 0 : 8);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0058  */
    @Override // m.x
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(m.m r11) {
        /*
            Method dump skipped, instruction units count: 305
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.ListMenuItemView.a(m.m):void");
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public final void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.B;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.B.getLayoutParams();
        rect.top = this.B.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin + rect.top;
    }

    @Override // m.x
    public m getItemData() {
        return this.f860u;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        setBackground(this.D);
        TextView textView = (TextView) findViewById(f.title);
        this.f863x = textView;
        int i = this.E;
        if (i != -1) {
            textView.setTextAppearance(this.F, i);
        }
        this.f865z = (TextView) findViewById(f.shortcut);
        ImageView imageView = (ImageView) findViewById(f.submenuarrow);
        this.A = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(this.H);
        }
        this.B = (ImageView) findViewById(f.group_divider);
        this.C = (LinearLayout) findViewById(f.content);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i, int i10) {
        if (this.f861v != null && this.G) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f861v.getLayoutParams();
            int i11 = layoutParams.height;
            if (i11 > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = i11;
            }
        }
        super.onMeasure(i, i10);
    }

    public void setCheckable(boolean z2) {
        CompoundButton compoundButton;
        View view;
        if (!z2 && this.f862w == null && this.f864y == null) {
            return;
        }
        if ((this.f860u.f8251x & 4) != 0) {
            if (this.f862w == null) {
                RadioButton radioButton = (RadioButton) getInflater().inflate(g.abc_list_menu_item_radio, (ViewGroup) this, false);
                this.f862w = radioButton;
                LinearLayout linearLayout = this.C;
                if (linearLayout != null) {
                    linearLayout.addView(radioButton, -1);
                } else {
                    addView(radioButton, -1);
                }
            }
            compoundButton = this.f862w;
            view = this.f864y;
        } else {
            if (this.f864y == null) {
                CheckBox checkBox = (CheckBox) getInflater().inflate(g.abc_list_menu_item_checkbox, (ViewGroup) this, false);
                this.f864y = checkBox;
                LinearLayout linearLayout2 = this.C;
                if (linearLayout2 != null) {
                    linearLayout2.addView(checkBox, -1);
                } else {
                    addView(checkBox, -1);
                }
            }
            compoundButton = this.f864y;
            view = this.f862w;
        }
        if (z2) {
            compoundButton.setChecked(this.f860u.isChecked());
            if (compoundButton.getVisibility() != 0) {
                compoundButton.setVisibility(0);
            }
            if (view == null || view.getVisibility() == 8) {
                return;
            }
            view.setVisibility(8);
            return;
        }
        CheckBox checkBox2 = this.f864y;
        if (checkBox2 != null) {
            checkBox2.setVisibility(8);
        }
        RadioButton radioButton2 = this.f862w;
        if (radioButton2 != null) {
            radioButton2.setVisibility(8);
        }
    }

    public void setChecked(boolean z2) {
        CompoundButton compoundButton;
        if ((this.f860u.f8251x & 4) != 0) {
            if (this.f862w == null) {
                RadioButton radioButton = (RadioButton) getInflater().inflate(g.abc_list_menu_item_radio, (ViewGroup) this, false);
                this.f862w = radioButton;
                LinearLayout linearLayout = this.C;
                if (linearLayout != null) {
                    linearLayout.addView(radioButton, -1);
                } else {
                    addView(radioButton, -1);
                }
            }
            compoundButton = this.f862w;
        } else {
            if (this.f864y == null) {
                CheckBox checkBox = (CheckBox) getInflater().inflate(g.abc_list_menu_item_checkbox, (ViewGroup) this, false);
                this.f864y = checkBox;
                LinearLayout linearLayout2 = this.C;
                if (linearLayout2 != null) {
                    linearLayout2.addView(checkBox, -1);
                } else {
                    addView(checkBox, -1);
                }
            }
            compoundButton = this.f864y;
        }
        compoundButton.setChecked(z2);
    }

    public void setForceShowIcon(boolean z2) {
        this.K = z2;
        this.G = z2;
    }

    public void setGroupDividerEnabled(boolean z2) {
        ImageView imageView = this.B;
        if (imageView != null) {
            imageView.setVisibility((this.I || !z2) ? 8 : 0);
        }
    }

    public void setIcon(Drawable drawable) {
        k kVar = this.f860u.f8241n;
        boolean z2 = this.K;
        if (z2 || this.G) {
            ImageView imageView = this.f861v;
            if (imageView == null && drawable == null && !this.G) {
                return;
            }
            if (imageView == null) {
                ImageView imageView2 = (ImageView) getInflater().inflate(g.abc_list_menu_item_icon, (ViewGroup) this, false);
                this.f861v = imageView2;
                LinearLayout linearLayout = this.C;
                if (linearLayout != null) {
                    linearLayout.addView(imageView2, 0);
                } else {
                    addView(imageView2, 0);
                }
            }
            if (drawable == null && !this.G) {
                this.f861v.setVisibility(8);
                return;
            }
            ImageView imageView3 = this.f861v;
            if (!z2) {
                drawable = null;
            }
            imageView3.setImageDrawable(drawable);
            if (this.f861v.getVisibility() != 0) {
                this.f861v.setVisibility(0);
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence == null) {
            if (this.f863x.getVisibility() != 8) {
                this.f863x.setVisibility(8);
            }
        } else {
            this.f863x.setText(charSequence);
            if (this.f863x.getVisibility() != 0) {
                this.f863x.setVisibility(0);
            }
        }
    }
}
