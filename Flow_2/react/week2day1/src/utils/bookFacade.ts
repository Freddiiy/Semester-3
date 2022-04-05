export interface IBook {
    id: number,
    title: string,
    info: string
}

let books = [
        { id: 100,title: "How to Learn JavaScript - Vol 1", info: "Study hard"},
        { id: 101,title: "How to Learn ES6", info: "Complete all exercises :-)"},
        { id: 102,title: "How to Learn React",info: "Complete all your CA's"},
        { id: 103,title: "Learn React", info: "Don't drink beer(s), until Friday (after four)"
        }
    ]

    
let nextId = 104;  


export const getBooks = () => { return books}
    
export const findBook = (id: number) => {
      const bookId = isNaN(id) ? id : Number(id);
      return books.find(book=>book.id===bookId)
    }
    
export const deleteBook = (id: number) => {    
      const bookId = isNaN(id) ? Number(id) : id;
       books = books.filter(book=>book.id!==bookId)
    }
    
export const addBook = (book: IBook) => {
      book.id = nextId
      books.push(book)
      nextId++;
    }