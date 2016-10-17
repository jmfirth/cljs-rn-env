(ns native-base.core
  (:refer-clojure :exclude [list])
  (:require [reagent.core :refer [adapt-react-class]]))

(def NativeBase (js/require "native-base"))

(def header (adapt-react-class (.-Header NativeBase)))
(def footer (adapt-react-class (.-Footer NativeBase)))
(def title (adapt-react-class (.-Title NativeBase)))
(def container (adapt-react-class (.-Container NativeBase)))
(def content (adapt-react-class (.-Content NativeBase)))
(def button (adapt-react-class (.-Button NativeBase)))
(def text (adapt-react-class (.-Text NativeBase)))
;; (def switch (adapt-react-class (.-Switch NativeBase)))
;; (def picker (adapt-react-class (.-Picker NativeBase)))
;; (def list (adapt-react-class (.-List NativeBase)))
;; (def list-item (adapt-react-class (.-ListItem NativeBase)))
(def card-item (adapt-react-class (.-CardItem NativeBase)))
;; (def h1 (adapt-react-class (.-H1 NativeBase)))
;; (def h2 (adapt-react-class (.-H2 NativeBase)))
;; (def h3 (adapt-react-class (.-H3 NativeBase)))
;; (def view (adapt-react-class (.-View NativeBase)))
(def row (adapt-react-class (.-Row NativeBase)))
(def col (adapt-react-class (.-Col NativeBase)))
(def grid (adapt-react-class (.-Grid NativeBase)))
(def input-group (adapt-react-class (.-InputGroup NativeBase)))
(def input (adapt-react-class (.-Input NativeBase)))
;;(def textarea (adapt-react-class (.-TextArea NativeBase)))
(def icon (adapt-react-class (.-Icon NativeBase)))
;; (def thumbnail (adapt-react-class (.-Thumbnail NativeBase)))
(def card (adapt-react-class (.-Card NativeBase)))
;; (def card-swiper (adapt-react-class (.-CardSwiper NativeBase)))
;; (def deck-swiper (adapt-react-class (.-DeckSwiper NativeBase)))
;; (def badge (adapt-react-class (.-Badge NativeBase)))
;; (def spinner (adapt-react-class (.-Spinner NativeBase)))
;; (def checkbox (adapt-react-class (.-Checkbox NativeBase)))
;; (def radio (adapt-react-class (.-Radio NativeBase)))
;; (def drawer (adapt-react-class (.-Drawer NativeBase)))
 (def footer-tab (adapt-react-class (.-FooterTab NativeBase)))
 (def tabs (adapt-react-class (.-Tabs NativeBase)))

(comment "
import Drawer from './Components/vendor/react-native-drawer';
import Header from './Components/Widgets/Header';
import Footer from './Components/Widgets/Footer';
import Title from './Components/Widgets/Title';
import Container from './Components/Widgets/Container';
import Content from './Components/Widgets/Content';
import Button from './Components/Widgets/Button';
import Text from './Components/Widgets/Text';
import Switch from './Components/Widgets/Switch';
import Picker from './Components/Widgets/Picker';
import List from './Components/Widgets/List';
import ListItem from './Components/Widgets/ListItem';
import CardItem from './Components/Widgets/CardItem';
import CardSwiper from './Components/Widgets/CardSwiper';
import DeckSwiper from './Components/Widgets/DeckSwiper';
import H1 from './Components/Widgets/H1';
import H2 from './Components/Widgets/H2';
import H3 from './Components/Widgets/H3';
import View from './Components/Widgets/View';
import Input from './Components/Widgets/Input';
import Textarea from './Components/Widgets/Textarea';
import InputGroup from './Components/Widgets/InputGroup';
import Icon from './Components/Widgets/Icon';
import FooterTab from './Components/Widgets/FooterTab';
import Thumbnail from './Components/Widgets/Thumbnail';
import CheckBox from './Components/Widgets/Checkbox';
import Radio from './Components/Widgets/Radio';
import Card from './Components/Widgets/Card';
import Badge from './Components/Widgets/Badge';
import Spinner from './Components/Widgets/Spinner';
// import ProgressBar from './Components/Widgets/ProgressBar';
import { Col, Row, Grid } from 'react-native-easy-grid;
import ScrollableTabView from './Components/Widgets/Tabs';
	Header: Header,
	Footer: Footer,
	Title: Title,
	Container: Container,
	Content: Content,
	Button: Button,
	Text: Text,
	Switch: Switch,
	Picker: Picker,
	List: List,
	ListItem: ListItem,
	CardItem: CardItem,
	H1: H1,
	H2: H2,
	H3: H3,
	View: View,
	Row: Row,
	Col: Col,
	Grid: Grid,
	InputGroup: InputGroup,
	Input: Input,
	Textarea: Textarea,
	Icon: Icon,
	Thumbnail: Thumbnail,
	Card: Card,
	CardSwiper: CardSwiper,
	DeckSwiper: DeckSwiper,
	Badge: Badge,
	Spinner: Spinner,
	CheckBox: CheckBox,
	Radio: Radio,
	// ProgressBar: ProgressBar,
	Drawer: Drawer,
	FooterTab: FooterTab,
	Tabs : ScrollableTabView
")
